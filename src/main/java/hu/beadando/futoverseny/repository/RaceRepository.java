package hu.beadando.futoverseny.repository;

import hu.beadando.futoverseny.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
