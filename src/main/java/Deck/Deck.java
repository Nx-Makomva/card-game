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
        switch (card.getSuit()) {
            case "Clubs":
            case "Spades":
                visualBuilder.append(ColorUtils.colourise("        _____       \n", ColorUtils.BLUE));
                break;
            case "Diamonds":
            case "Hearts":
                visualBuilder.append(ColorUtils.colourise("        _____       \n", ColorUtils.RED));
                break;
        }
        if (card.getSymbol().equals("10")) {
            if (card.getSuit().equals("Clubs") || card.getSuit().equals("Spades")) {
                visualBuilder.append(ColorUtils.BLUE).append("       |").append(card.getSymbol()).append("   |\n");
            } else {
                visualBuilder.append(ColorUtils.RED).append("       |").append(card.getSymbol()).append("   |\n");
            }
        } else {
            if (card.getSuit().equals("Clubs") || card.getSuit().equals("Spades")) {
                visualBuilder.append(ColorUtils.BLUE).append("       |").append(card.getSymbol()).append("    |\n");
            } else {
                visualBuilder.append(ColorUtils.RED).append("       |").append(card.getSymbol()).append("    |\n");
            }
        }


        switch (card.getSuit()) {
            case "Clubs":
                visualBuilder.append(ColorUtils.BLUE).append("       |  ♣  | \n");
                visualBuilder.append(ColorUtils.BLUE).append("       |_____|       \n");
                break;
            case "Diamonds":
                visualBuilder.append(ColorUtils.RED).append("       |  ♦  | \n");
                visualBuilder.append(ColorUtils.RED).append("       |_____|       \n");
                break;
            case "Hearts":
                visualBuilder.append(ColorUtils.RED).append("       |  ♥  | \n");
                visualBuilder.append(ColorUtils.RED).append("       |_____|       \n");
                break;
            case "Spades":
                visualBuilder.append(ColorUtils.BLUE).append("       |  ♠  | \n");
                visualBuilder.append(ColorUtils.BLUE).append("       |_____|       \n");
                break;
        }
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

