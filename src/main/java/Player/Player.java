package Player;

import Card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // variables
    private String playerName;
    private int wallet = 500;
    private int playerScore;
    private boolean isHuman;
    private List<Card> currentHand;

    // constructors
    public Player(String playerName, boolean isHuman) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.playerScore = 0; // initialise to 0
        this.currentHand = new ArrayList<>();
    }
    public Player() {
    }

    // getters and setters
    public String getName() {
        return playerName;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public List<Card> getCurrentHand() {
        return currentHand;
    }

    // methods

    public int getHandValue() {
        int totalValue = 0;
        for (Card card : currentHand) {
            totalValue += card.getValue();
        }
        return totalValue;
    }

    public void setCurrentHand(List<Card> cards) {
        this.currentHand = cards;
    }

    public void addCardsToHand(List<Card> cards) {
        if (this.currentHand == null) {
            this.currentHand = new ArrayList<>();
        }
        this.currentHand.addAll(cards);
    }
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
