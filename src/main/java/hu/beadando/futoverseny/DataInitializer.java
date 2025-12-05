package hu.beadando.futoverseny;

import hu.beadando.futoverseny.entity.Gender;
import hu.beadando.futoverseny.entity.Race;
import hu.beadando.futoverseny.entity.Result;
import hu.beadando.futoverseny.entity.Runner;
import hu.beadando.futoverseny.repository.RaceRepository;
import hu.beadando.futoverseny.repository.ResultRepository;
import hu.beadando.futoverseny.repository.RunnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(RunnerRepository runnerRepo,
                               RaceRepository raceRepo,
                               ResultRepository resultRepo) {
        return args -> {
            // Fut�k (min. 4)
            Runner r1 = runnerRepo.save(new Runner("Kiss P�ter", 30, Gender.MALE));
            Runner r2 = runnerRepo.save(new Runner("Nagy Anna", 25, Gender.FEMALE));
            Runner r3 = runnerRepo.save(new Runner("Szab� L�szl�", 40, Gender.MALE));
            Runner r4 = runnerRepo.save(new Runner("T�th J�lia", 35, Gender.FEMALE));

            // Versenyek (min. 2)
            Race race1 = raceRepo.save(new Race("V�rosi F�lmaraton", 21.1));
            Race race2 = raceRepo.save(new Race("Tavaszi 10 km", 10));

            // Eredm�nyek (min. 6)
            resultRepo.save(new Result(r1, race1, 110));
            resultRepo.save(new Result(r2, race1, 105));
            resultRepo.save(new Result(r3, race1, 130));

            resultRepo.save(new Result(r1, race2, 50));
            resultRepo.save(new Result(r2, race2, 48));
            resultRepo.save(new Result(r4, race2, 55));
        };
    }
}
