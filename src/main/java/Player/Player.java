package Player;

import Card.Card;
import Utils.ColorUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Utils.ColorUtils.RESET;

public class Player {

    // variables
    protected String playerName;
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
            System.out.println("These cards have been removed from " + playerName + "'s deck: " );
            printHandVisual(cardsToRemove);
            System.out.println(ColorUtils.colourise("-----------------------------------------------------------------\n", RESET));
        }
    }


    public static void printHandVisual(List<Card> hand) {

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();

        for (Card card : hand) {
            String[] lines = card.getVisual().split("\n");
            line1.append(lines[0]).append(" ");
            line2.append(lines[1]).append("       ");
            line3.append(lines[2]).append("      ");
            line4.append(lines[3]).append("");
        }

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }


    @Override
    public String toString() {
        return playerName;
    }
}
