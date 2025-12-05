package hu.beadando.futoverseny.repository;

import hu.beadando.futoverseny.entity.Race;
import hu.beadando.futoverseny.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByRaceOrderByTimeMinutesAsc(Race race);
}
