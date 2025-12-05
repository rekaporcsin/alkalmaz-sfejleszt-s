package hu.beadando.futoverseny.controller;

import hu.beadando.futoverseny.entity.Race;
import hu.beadando.futoverseny.entity.Result;
import hu.beadando.futoverseny.repository.RaceRepository;
import hu.beadando.futoverseny.repository.ResultRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RaceViewController {

    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    public RaceViewController(RaceRepository raceRepository,
                              ResultRepository resultRepository) {
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    // Főoldal -> irányítás a versenyek listájára
    @GetMapping("/")
    public String home() {
        return "redirect:/races";
    }

    // Versenyek listázása
    @GetMapping("/races")
    public String listRaces(Model model) {
        List<Race> races = raceRepository.findAll();
        model.addAttribute("races", races);
        return "races";          // -> races.html
    }

    // Új verseny form
    @GetMapping("/races/new")
    public String showNewRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "new-race";       // -> new-race.html
    }

    // Új verseny mentése (form submit)
    @PostMapping("/races")
    public String createRace(@ModelAttribute Race race) {
        raceRepository.save(race);
        return "redirect:/races";
    }

    // Verseny részletei + futók eredményei
    @GetMapping("/races/{id}")
    public String raceDetails(@PathVariable Long id, Model model) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Race not found: " + id));

        List<Result> results = resultRepository.findByRaceOrderByTimeMinutesAsc(race);

        model.addAttribute("race", race);
        model.addAttribute("results", results);

        return "race-details";   // -> race-details.html
    }
}
