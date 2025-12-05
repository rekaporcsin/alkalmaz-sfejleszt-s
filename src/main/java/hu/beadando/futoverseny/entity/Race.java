package hu.beadando.futoverseny.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    private double distanceKm;

    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private List<Result> results;

    public Race() {
    }

    public Race(String name, double distanceKm) {
        this.name = name;
        this.distanceKm = distanceKm;
    }

    public Long getId() {
        return id;
    }

    public String getName() {          // fontos
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceKm() {    // fontos
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
