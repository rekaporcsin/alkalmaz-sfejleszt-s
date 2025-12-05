package hu.beadando.futoverseny.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(0)
    private int age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "runner")
    @JsonIgnore            
    private List<Result> results;

    public Runner() {
    }

    public Runner(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // ---- GETTEREK / SETTEREK ----

    public Long getId() {
        return id;
    }

    public String getName() {         // fontos
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {             // fontos
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {       // fontos
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
