package Deck;

import Card.Card;
import Utils.ColorUtils;

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

    public void printCardVisual(Card card) {
        StringBuilder visualBuilder = new StringBuilder();
        visualBuilder.append(ColorUtils.RESET);

        // Define card dimensions
        String topBorder = " _____ ";
        String bottomBorder = "|_____|";
        String suitSymbol = "";
        String colorCode = "";

        switch (card.getSuit()) {
            case "Clubs":
                suitSymbol = "♣";
                colorCode = ColorUtils.BLUE;
                break;
            case "Diamonds":
                suitSymbol = "♦";
                colorCode = ColorUtils.RED;
                break;
            case "Hearts":
                suitSymbol = "♥";
                colorCode = ColorUtils.RED;
                break;
            case "Spades":
                suitSymbol = "♠";
                colorCode = ColorUtils.BLUE;
                break;
        }

        visualBuilder.append(ColorUtils.colourise(topBorder, colorCode)).append("\n");

        // Symbol line with proper spacing
        String symbol = card.getSymbol();
        String symbolLine = "|" + symbol;
        if (symbol.equals("10")) {
            symbolLine += "   |";
        } else {
            symbolLine += "    |";
        }
        visualBuilder.append(ColorUtils.colourise(symbolLine, colorCode)).append("\n");

        // Suit line and bottom border
        String suitLine = "|  " + suitSymbol + "  |";
        visualBuilder.append(ColorUtils.colourise(suitLine, colorCode)).append("\n");
        visualBuilder.append(ColorUtils.colourise(bottomBorder, colorCode)).append("\n");

        visualBuilder.append(ColorUtils.RESET);
        card.setVisual(visualBuilder.toString());
    }


    public List<Card> dealCard(int numberOfCards) {
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

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
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

