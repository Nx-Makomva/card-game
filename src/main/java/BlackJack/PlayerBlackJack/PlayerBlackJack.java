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

    public void printHandVisual(List<Card> hand) {
        // Initialize StringBuilders for each line of the card representation
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();

        // Iterate over each card and append the respective lines
        for (Card card : hand) {
            String[] lines = card.getVisual().split("\n");
            line1.append(lines[0]).append(" ");
            line2.append(lines[1]).append("       ");
            line3.append(lines[2]).append("      ");
            line4.append(lines[3]).append("");
        }

        // Print each line of all cards in sequence
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }
}
