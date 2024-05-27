package Deck;

import Card.Card;

import java.util.ArrayList;
import java.util.Collections;
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
                deckOfCards.add(new Card(suit, symbol, value));
            }
            // cards should immediately be shuffled after a deck is created?? so first card picked is always random
        }
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

        // dealAllCards method ????

        public void sortDeck () {
        deckOfCards = deckOfCards.stream()
                .sorted((a, b) -> a.getValue() - b.getValue())
                .collect(Collectors.toList());
        }

        public void sortDeckBySuit() {

//            deckOfCards = deckOfCards.stream()
//                    .filter(CardAndDeck.Card -> CardAndDeck.Card.getSuit())
//                    .sorted((a,b) -> a.getValue() - b.getValue())
//                    .collect(Collectors.toList());
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

