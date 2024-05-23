package BlackJack;

import Card.Card;

import java.util.List;

public class Player {

    private String name;
    private int wallet = 500;
    private List<Card> currentHand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHandValue() {
        int totalValue = 0;
        for (Card card : currentHand) {
            totalValue += card.getValue();
        }
        return totalValue;
    }

    public void setCurrentHand(List<Card> currentHand) {
        this.currentHand = currentHand;
    }
}
