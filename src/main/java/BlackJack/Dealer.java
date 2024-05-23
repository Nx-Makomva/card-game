package BlackJack;

import Card.Card;

import java.util.List;

public class Dealer {
    private List<Card> currentHand;

    public List<Card> getCurrentHand() {
        return currentHand;
    }

    public void setCurrentHand(List<Card> currentHand) {
        this.currentHand = currentHand;
    }
}
