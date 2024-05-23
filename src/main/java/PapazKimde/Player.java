package PapazKimde;

public class Player {

    // variables
    protected String playerName;
    protected int playerScore ;
    protected boolean isComputer;

    // constructor
    public Player(String playerName, boolean isComputer) {
        this.playerName = playerName;
        this.isComputer = isComputer;
        this.playerScore = 0; // initialise to 0
    }

    public Player() {
    }

    // methods

    // needs to check if computer or real player
    public boolean isComputer() {
        return false;
    }

    // needs to take in name and set it
    // if computer then set name is 'computer[number])

    // update score
    // to be overloaded by whatever game is doing?
    public static void updateScore(){

    }


}
