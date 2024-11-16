public class Contestants {
    private int id;
    private int numOfVotes;
    private String name;

    public Contestants(String Name, int ID){
        this.id = ID;
        this.name = Name;
        this.numOfVotes = 0;
    }

    public int getId() {
        return id;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void increaseVote() {
        numOfVotes += 1;
    }

    public String getName() {
        return name;
    }
}
