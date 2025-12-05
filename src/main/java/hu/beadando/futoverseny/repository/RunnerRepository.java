package hu.beadando.futoverseny.repository;

import hu.beadando.futoverseny.entity.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<Runner, Long> {
}
