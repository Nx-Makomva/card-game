package Player;

import Card.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    // variables
    protected String playerName;
    protected int wallet = 500;
    protected int playerScore;
    protected boolean isHuman;
    protected List<Card> currentHand;


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

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
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
        List<Card> cardsToRemove = new ArrayList<>();
        // using sets because do not want duplicates
        Set<Integer> indicesToSkip = new HashSet<>();

        // iterating through each card in current hand
        for (int i = 0; i < currentHand.size(); i++) {
            // Skip this index if it's already part of a pair
            if (indicesToSkip.contains(i)) {
                continue;
            }
            Card cardToMatch1 = currentHand.get(i);
            boolean pairFound = false;

            // inner loop to compare selected card with rest of hand
            for (int j = i + 1; j < currentHand.size(); j++) {
                // Skip this index if it's already part of a pair
                if (indicesToSkip.contains(j)) {
                    continue;
                }

                Card cardToMatch2 = currentHand.get(j);
                // check if there is a match
                if (cardToMatch1.getValue() == cardToMatch2.getValue()) {
                    cardsToRemove.add(cardToMatch1);
                    cardsToRemove.add(cardToMatch2);
                    indicesToSkip.add(i);
                    indicesToSkip.add(j);
                    pairFound = true;
                    break;
                }
            }
            // skipping current iteration once pair is found and moving onto next card in currentHand
            if (pairFound) {
                continue;
            }
        }
        currentHand.removeAll(cardsToRemove);
        if (cardsToRemove.size() == 2){
            System.out.println("These cards have been removed from your deck: " + cardsToRemove);
        }
    }

    public void updateScore() {
        // something to set the score? or update score for the player?
    }

    @Override
    public String toString() {
        return playerName;
    }


}
