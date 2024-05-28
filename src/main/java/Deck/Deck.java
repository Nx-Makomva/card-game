package Deck;

import Card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Deck {

    private List<Card> deckOfCards = new ArrayList<>();
    private List<String> suits = Card.getAllSuits();
    private List<String> symbols = Card.getAllSymbols();
    private int value = 0;


    public Deck(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public Deck() {
        for (String suit : suits) {
            for (String symbol : symbols) {
                if (value >= 13) {
                    value = 0;
                }
                value++;
                Card card = new Card(suit, symbol, value);
                deckOfCards.add(card);
                printCardVisual(card);
            }
        }
    }
    private void printCardVisual(Card card) {
        System.out.print("        _____      ");

        System.out.println();

        if (card.getSymbol().equals("10")) {
            System.out.print("       |" + card.getSymbol() + "   |    ");
        } else {
            System.out.print("       |" + card.getSymbol() + "    |    ");
        }

        System.out.println();

        switch (card.getSuit()) {
            case "Clubs":
                System.out.print("       |  ♣  |    ");
                break;
            case "Diamonds":
                System.out.print("       |  ♦  |    ");
                break;
            case "Hearts":
                System.out.print("       |  ♥  |    ");
                break;
            case "Spades":
                System.out.print("       |  ♠  |    ");
                break;
        }

        System.out.println();
        System.out.print("       |____ |    ");
        System.out.println();
    }


        public List<Card> dealCard (int numberOfCards) {
        List<Card> dealtCards = new ArrayList<>();

            for (int i = 0; i < numberOfCards; i++) {
                if (i < deckOfCards.size()) {
                    if (!deckOfCards.isEmpty()) {
                        Card card = deckOfCards.remove(0);
                        dealtCards.add(card);
                    }
                } else {
                    System.out.println("\nNo more cards in deck, one moment whilst I reshuffle the cards");
                    resetDeck();
                    shuffleDeck();
                }
            }
            return dealtCards;
        }

        public void sortDeck () {
        deckOfCards = deckOfCards.stream()
                .sorted((a, b) -> a.getValue() - b.getValue())
                .collect(Collectors.toList());
        }

        public void sortDeckBySuit() {
            deckOfCards = deckOfCards.stream()
                    .sorted(Comparator.comparing(Card::getSuit).thenComparing(Card::getValue))
                    .collect(Collectors.toList());
        }

        public void shuffleDeck() {
             Collections.shuffle(deckOfCards);
        }

        public void resetDeck() {
            deckOfCards.clear();
            for (String suit : suits) {
                for (String symbol : symbols) {
                    if (value >= 13) {
                        value = 0;
                    }
                    value++;
                    deckOfCards.add(new Card(suit, symbol, value));
                }
            }
        }

        public void printDeck() {
            for (Card card : deckOfCards) {
                System.out.println(card);
            }
        }
    }

