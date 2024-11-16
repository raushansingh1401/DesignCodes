import java.time.LocalDateTime;
import java.util.List;

public class VotingSystem {

    private List<Contestants> contestantsList;
    private VotingWindow votingWindow;

    public VotingSystem(List<Contestants> contestantsList, LocalDateTime startTime){
        this.contestantsList = contestantsList;
        this.votingWindow = new VotingWindow(startTime, startTime.plusHours(24));
    }

    public void voteForContestant(int contestantID) {
        if(votingWindow.isVotingOpen()){
            for(Contestants contestant : contestantsList){
                if (contestantID == contestant.getId()){
                    contestant.increaseVote();
                    System.out.println("Vote counted for " + contestant.getName());
                    return;
                }
            }
            System.out.println("Invalid contestant ID "+contestantID);
        }else{
            System.out.println("Voting is closed");
        }
    }

    public void getLeaderBoard() {
        if(votingWindow.isVotingOpen()){
            contestantsList.sort((c1, c2)-> c2.getNumOfVotes() - c1.getNumOfVotes());
            System.out.println("Leaderboard Real-time : ");
            for(Contestants contestant : contestantsList){
                System.out.println(contestant.getName() + " - Votes : " + contestant.getNumOfVotes());
            }
        }else{
            System.out.println(" Voting window is closed");
        }
    }
}
