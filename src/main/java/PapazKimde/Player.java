package PapazKimde;

import Card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // variables
    protected String playerName;
    protected int playerScore ;
    protected boolean isHuman;
    protected List<Card> hand;

    // constructor
    public Player(String playerName, boolean isHuman) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.playerScore = 0; // initialise to 0
        this.hand = new ArrayList<>();
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


    // these three methods might be methods for the player class, so they can be automated for computer?

    public void pairRemoval() {
        // each player needs to go through their cards and remove any pairs
        // go through each card in list, if there's match in list, then remove
        // need to make sure it only removes pairs, not 3s
    }

    public void cardPullFromOtherPlayer() {
        // mimic player 1 pulling random card from player 2's deck -> ask for user input
        // "choose a card from player x's deck"
        // print the number of cards player x has ?

    }

    public void countScore() {
        // scoring: 2 player : winner = x points
        // 2 or more : first x points, second x-5 etc etc..
        // loser 0 points
    }

    @Override
    public String toString() {
        return playerName;
    }
}
