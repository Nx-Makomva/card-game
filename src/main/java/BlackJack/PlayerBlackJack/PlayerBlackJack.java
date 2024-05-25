package BlackJack.PlayerBlackJack;

import Card.Card;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerBlackJack extends Player {

    protected Card userPlayedCard = null;

    public PlayerBlackJack (String playerName, boolean isHuman) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.playerScore = 0; // initialise to 0
        this.currentHand = new ArrayList<>();
    }

    public Card getUserPlayedCard() {
        return userPlayedCard;
    }

    @Override
    public void addCardsToHand(List<Card> cards) {
        if (currentHand == null) {
            currentHand = new ArrayList<>();
        }
        currentHand.addAll(cards);
        System.out.println("You received: " + cards);
        System.out.println("Your new hand is: " + currentHand);
    }

    public List<Card> determinePlayableCards(List<Card> playerHand, int cardValue, String cardSuit) {
        List<Card> playableCards = new ArrayList<>();
        for (Card card : playerHand) {
            if (card.getValue() == cardValue || card.getSuit().equals(cardSuit)) {
                playableCards.add(card);
            }
        }
        return playableCards;
    }

    public void playCardFromHand(int userChoice, List<Card> playableCards) {
        if (userChoice >= 0 && userChoice < playableCards.size()) {
            Card playedCard = playableCards.get(userChoice);
            userPlayedCard = playedCard;
            System.out.println("\n You have chosen to play: " + playedCard);
            currentHand.remove(playedCard);
        }
    }


}
