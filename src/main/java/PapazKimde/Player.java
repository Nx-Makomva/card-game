package PapazKimde;

public class Player {

    // variables
    protected String playerName;
    protected int playerScore ;
    protected boolean isHuman;

    // constructor
    public Player(String playerName, boolean isHuman) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.playerScore = 0; // initialise to 0
    }

    public Player() {
    }

    // methods


    // needs to take in name and set it
    // if computer then set name is 'computer[number])

    // update score
    // to be overloaded by whatever game is doing?
    public static void updateScore(){

    }

    @Override
    public String toString() {
        return playerName;
    }
}
