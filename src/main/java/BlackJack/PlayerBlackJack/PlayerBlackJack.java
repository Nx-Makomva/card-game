package BlackJack.PlayerBlackJack;

import BlackJack.BlackJackMain;
import Card.Card;
import Deck.Deck;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//                    List<Card> userPlayedCards = player.playerTakeTurn(currentCard, userChoice, playableCards);
//                    playingCard.addAll(userPlayedCards);

public class PlayerBlackJack extends Player {

    protected Card userPlayedCard = null;
//    private final Deck deck;
//    private final List<Card> PICKUP_CARD;
//    private boolean endTurnEarly = false;
//    private List<Card> playedCards = new ArrayList<>();
    private boolean isPowerCard;

    public PlayerBlackJack (String playerName, boolean isHuman, Deck deck) {
        this.playerName = playerName;
        this.isHuman = isHuman;
        this.currentHand = new ArrayList<>();
//        this.deck = deck;
//        this.PICKUP_CARD = deck.dealCard(1);
    }

    public Card getUserPlayedCard() {
        return userPlayedCard;
    }
//
//    public void setEndTurnEarly(boolean endTurnEarly) {
//        this.endTurnEarly = endTurnEarly;
//    }

    public boolean isPowerCard() {
        return isPowerCard;
    }

//    public List<Card> getPlayableCards() {
//        return playableCards;
//    }

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

//    public List<Card> playerTakeTurn(Card currentCard, int userChoice, List<Card> playableCards) {
//        if (deck == null) {
//            throw new IllegalStateException("Deck is not initialized");
//        }
//
//        playedCards.clear();
//        String cardSymbol = currentCard.getSymbol();
//        String cardSuit = currentCard.getSuit();
//
////        determinePlayableCards(currentHand, cardSymbol, cardSuit);
//
//
//        if (!playableCards.isEmpty()) {
//            playCardFromHand(userChoice, playableCards);
//            playedCards.add(userPlayedCard);
////            playerHandlePowerCard(playedCards, currentCard);
//
//            if (endTurnEarly) {
//                return null;
//            }
//
//            System.out.println(playerName + " played: " + playedCards);
//            BlackJackMain.setPickedUp(false);
//
//        } else {
////            playerHandlePowerCard(playedCards, currentCard);
//            if (endTurnEarly) {
//                BlackJackMain.setPickedUp(true);
//                return null;
//            }
//            addCardsToHand(PICKUP_CARD);
//            System.out.println(playerName + " picked up a card.");
//        }
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return playedCards;
//    }



//    private boolean isPowerCard(String symbol) {
//        return "A".equals(symbol) || "K".equals(symbol) || "Q".equals(symbol) ||
//                "J".equals(symbol) || "8".equals(symbol) || "2".equals(symbol);
//
//    }
//
//    public void playerHandlePowerCard(List<Card> playedCards, Card currentCard) {
//        System.out.println("Handle powerCard triggered");
//        Random random = new Random();
//        int randomIndex;
//        Card extraCard;
//

//        if (userPlayedCard != null && isPowerCard(userPlayedCard.getSymbol())) {
//            if ("Q".equals(userPlayedCard.getSymbol()) || "A".equals(userPlayedCard.getSymbol())) {
//                if (!currentHand.isEmpty()) {
//                    randomIndex = random.nextInt(currentHand.size());
//                    extraCard = currentHand.get(randomIndex);
//                    currentHand.remove(extraCard);
//                    playedCards.add(extraCard);
//                    BlackJackMain.setPickedUp(false);
//                } else {
//                    addCardsToHand(PICKUP_CARD);
//                    BlackJackMain.setPickedUp(true);
//                }
//            } else if...
//        if (isPowerCard(currentCard.getSymbol())) {
//            System.out.println("Handle powerCard: checking card in play");
//            System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
//            if ("8".equals(currentCard.getSymbol())) {
//                if (BlackJackMain.isPickedUp()) {
//                    BlackJackMain.setPickedUp(false);
//                } else {
//                    System.out.println("Sorry " + playerName + " your turn has been skipped");
//                    BlackJackMain.setPickedUp(true);
//                    endTurnEarly = true;
//                }
//            } else if ("2".equals(currentCard.getSymbol())) {
//                System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
//                if (BlackJackMain.isPickedUp()) {
//                    BlackJackMain.setPickedUp(false);
//                } else {
//                    boolean foundMatchingCard = false;
//                    for (Card card : playableCards) {
//                        if (card.getSymbol().equals(currentCard.getSymbol()) || card.getSuit().equals(currentCard.getSuit())) {
//                            foundMatchingCard = true;
//                            break;
//                        }
//                    }
//                    if (!foundMatchingCard) {
//                        System.out.println("I needed more cards anyway, thanks.");
//                        addCardsToHand(deck.dealCard(2));
//                        System.out.println(playerName + " picked up 2 cards");
//                        endTurnEarly = true;
//                        BlackJackMain.setPickedUp(true);
//                    }
//                }
//            } else if ("J".equals(currentCard.getSymbol()) && ("Spades".equals(currentCard.getSuit()) || "Clubs".equals(currentCard.getSuit()))) {
//                System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
//                if (BlackJackMain.isPickedUp()) {
//                    BlackJackMain.setPickedUp(false);
//                } else {
//                    // needs to know if player before picked up a card or not
//                    System.out.println("I see my enemies are alive and well");
//                    addCardsToHand(deck.dealCard(5));
//                    System.out.println(playerName + " picked up 5 cards");
//                    endTurnEarly = true;
//                    BlackJackMain.setPickedUp(true);
//                }
//            }
//        }
//    }
}
