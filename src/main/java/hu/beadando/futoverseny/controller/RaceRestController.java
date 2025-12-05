package hu.beadando.futoverseny.controller;

import hu.beadando.futoverseny.dto.AddResultRequest;
import hu.beadando.futoverseny.dto.AddRunnerRequest;
import hu.beadando.futoverseny.dto.RaceRunnerDto;
import hu.beadando.futoverseny.dto.UpdateRaceRequest;
import hu.beadando.futoverseny.entity.Race;
import hu.beadando.futoverseny.entity.Result;
import hu.beadando.futoverseny.entity.Runner;
import hu.beadando.futoverseny.repository.RaceRepository;
import hu.beadando.futoverseny.repository.ResultRepository;
import hu.beadando.futoverseny.repository.RunnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

@RestController
public class RaceRestController {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public RaceRestController(RunnerRepository runnerRepository,
                              RaceRepository raceRepository,
                              ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    // 1) /getRunners: összes futó alapadatai
    @GetMapping("/getRunners")
    public List<Runner> getRunners() {
        return runnerRepository.findAll();
    }

    // 2) /addRunner: futó felvétele
    @PostMapping("/addRunner")
    public Runner addRunner(@Valid @RequestBody AddRunnerRequest request) {
        Runner runner = new Runner(request.getName(), request.getAge(), request.getGender());
        return runnerRepository.save(runner);
    }

    // 3) /getRaceRunners/{id}: adott verseny futói név + időeredmény (emelkedő sorrend)
    @GetMapping("/getRaceRunners/{id}")
    public List<RaceRunnerDto> getRaceRunners(@PathVariable Long id) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Race not found"));

        List<Result> results = resultRepository.findByRaceOrderByTimeMinutesAsc(race);

        return results.stream()
                .map(r -> new RaceRunnerDto(r.getRunner().getName(), r.getTimeMinutes()))
                .collect(Collectors.toList());
    }

    // 4) /updateRace: verseny neve és távja módosítható
    @PostMapping("/updateRace")
    public Race updateRace(@Valid @RequestBody UpdateRaceRequest request) {
        Race race = raceRepository.findById(request.getRaceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Race not found"));

        race.setName(request.getName());
        race.setDistanceKm(request.getDistanceKm());

        return raceRepository.save(race);
    }

    // 5) /addResult: új eredmény rögzítése
    @PostMapping("/addResult")
    public Result addResult(@Valid @RequestBody AddResultRequest request) {
        Runner runner = runnerRepository.findById(request.getRunnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Runner not found"));

        Race race = raceRepository.findById(request.getRaceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Race not found"));

        Result result = new Result(runner, race, request.getTimeMinutes());
        return resultRepository.save(result);
    }

    // 6) /getAverageTime/{raceId}: átlagos futási idő percben
    @GetMapping("/getAverageTime/{raceId}")
    public double getAverageTime(@PathVariable Long raceId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Race not found"));

        List<Result> results = resultRepository.findByRaceOrderByTimeMinutesAsc(race);

        if (results.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No results for this race");
        }

        double sum = results.stream()
                .mapToInt(Result::getTimeMinutes)
                .sum();

        return sum / results.size();
    }
}
