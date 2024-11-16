import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        List<Contestants> contestantsList = new ArrayList<>();
        contestantsList.add(new Contestants("Contestant A", 1));
        contestantsList.add(new Contestants("Contestant B", 2));
        contestantsList.add(new Contestants("Contestant C", 3));
        contestantsList.add(new Contestants("Contestant D", 4));
        contestantsList.add(new Contestants("Contestant E", 5));
        contestantsList.add(new Contestants("Contestant F", 6));

        VotingSystem votingSystem = new VotingSystem(contestantsList, LocalDateTime.now());

        votingSystem.voteForContestant(3);
        votingSystem.voteForContestant(3);
        votingSystem.voteForContestant(2);
        votingSystem.voteForContestant(5);
        votingSystem.voteForContestant(3);
        votingSystem.voteForContestant(1);
        votingSystem.voteForContestant(3);
        votingSystem.voteForContestant(4);
        votingSystem.voteForContestant(4);
        votingSystem.voteForContestant(4);
        votingSystem.voteForContestant(4);
        votingSystem.voteForContestant(6);

        votingSystem.getLeaderBoard();
    }
}