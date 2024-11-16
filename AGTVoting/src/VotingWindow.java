import java.time.LocalDateTime;

public class VotingWindow {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public VotingWindow(LocalDateTime startTime, LocalDateTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isVotingOpen() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(startTime) && now.isBefore(endTime);
    }

}
