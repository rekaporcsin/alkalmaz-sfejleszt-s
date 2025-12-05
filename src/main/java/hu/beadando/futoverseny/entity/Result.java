package hu.beadando.futoverseny.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Runner runner;

    @ManyToOne
    @NotNull
    private Race race;

    @Min(1)
    private int timeMinutes;

    public Result() {
    }

    public Result(Runner runner, Race race, int timeMinutes) {
        this.runner = runner;
        this.race = race;
        this.timeMinutes = timeMinutes;
    }

    public Long getId() {
        return id;
    }

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }
}
