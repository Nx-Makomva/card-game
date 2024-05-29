package BlackJack.PlayerBlackJack;

import Card.Card;
import Deck.Deck;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerBlackJack extends Player {
    Deck deck;
    protected Card userPlayedCard = null;

    public PlayerBlackJack (String playerName, boolean isHuman, Deck deck) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.currentHand = new ArrayList<>();
        this.deck = deck;
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
        System.out.println("You received: \n" + cards);
        System.out.println("Your new hand is: \n");
        printHandVisual(currentHand);
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
            System.out.println("\n" + playerName + " played: \n" + playedCard);
            currentHand.remove(playedCard);
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
}
