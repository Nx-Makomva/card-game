package Player;

import Card.Card;

import java.util.List;

public class ComputerPlayer extends Player{


    public ComputerPlayer(List<Card> currentHandHand) {
        this.currentHand = currentHandHand;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        this.playerName = name;
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

    // override methods for automated behavior
//    @Override
//    public void removePairs() {
//        // automatically remove pairs for computer player
//    }
//
//    @Override
//    public void pullCardFrom(Player otherPlayer) {
//        // automatically pull a card from another player's hand for computer player
//    }

    // more methods specific to computer players
}
