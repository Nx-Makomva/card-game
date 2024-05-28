package BlackJack.PlayerBlackJack;

import Card.Card;
import Deck.Deck;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerBlackJack extends Player {

    protected Card userPlayedCard = null;

    public PlayerBlackJack (String playerName, boolean isHuman, Deck deck) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.currentHand = new ArrayList<>();
    }

    public Card getUserPlayedCard() {
        return userPlayedCard;
    }

    public static String setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");

        return scanner.nextLine().trim().toUpperCase();
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

    public List<Card> determinePlayableCards(List<Card> playerHand, Card currentCard) {
         List<Card> playableCards = new ArrayList<>();
        String cardSymbol = currentCard.getSymbol();
        String cardSuit = currentCard.getSuit();
        for (Card card : playerHand) {
            if (card.getSymbol().equals(cardSymbol) || card.getSuit().equals(cardSuit)) {
                playableCards.add(card);
            }
        }
        return playableCards;
    }

    public void playCardFromHand(int userChoice, List<Card> playableCards) {
        if (userChoice >= 0 && userChoice < playableCards.size()) {
            Card playedCard = playableCards.get(userChoice);
            userPlayedCard = playedCard;
            System.out.println("\n" + playerName + " played: " + playedCard);
            currentHand.remove(playedCard);
        }
    }
}
