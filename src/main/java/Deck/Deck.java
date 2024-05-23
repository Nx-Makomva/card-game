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

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void dealCard () {
            System.out.println(deckOfCards.get(0));
        }

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

