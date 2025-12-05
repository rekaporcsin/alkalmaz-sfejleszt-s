package hu.beadando.futoverseny.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
public class AddResultRequest {

    @NotNull
    private Long runnerId;
    @NotNull
    private Long raceId;
    @Min(1)
    private int timeMinutes;

    public AddResultRequest() {
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }
}
