package hu.beadando.futoverseny.dto;

public class RaceRunnerDto {

    private String runnerName;
    private int timeMinutes;

    public RaceRunnerDto() {
    }

    public RaceRunnerDto(String runnerName, int timeMinutes) {
        this.runnerName = runnerName;
        this.timeMinutes = timeMinutes;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }
}
