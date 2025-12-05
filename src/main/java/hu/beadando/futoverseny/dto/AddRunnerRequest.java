package hu.beadando.futoverseny.dto;

import hu.beadando.futoverseny.entity.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddRunnerRequest {

    @NotBlank
    private String name;
    @Min(0)
    private int age;
    @NotNull
    private Gender gender;

    public AddRunnerRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
