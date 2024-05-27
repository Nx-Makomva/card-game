package BlackJack.PlayerBlackJack;

import BlackJack.BlackJackMain;
import Card.Card;
import Deck.Deck;
import Player.ComputerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayerBlackJack extends ComputerPlayer {
    private final Deck deck;
    private final String NAME;
    private final List<Card> PICKUP_CARD;
    private boolean endTurnEarly = false;
    protected Card cpuPlayedCard = null;
    private List<Card> playedCards = new ArrayList<>();
    private List<Card> playableCards = new ArrayList<>();
    private final String[] CPU_RESPONSES_PICKING = {
            "This card’s not for you just yet. Let’s see what else I can pick up.\n",
            "Why reveal my hand when I can draw a mystery card?\n",
            "Strategically, it's better to hold this one and see what the deck offers.\n",
            "I think I’ll just keep you in suspense and draw a new card.\n",
            "I’m not about to make your life easy. Drawing a new card!\n",
            "Like I’d play this one right now. I’ll draw instead.\n",
            "Let’s keep things interesting. Drawing a new card!\n",
            "Guess what? I'm feeling mischievous today. Let's pick up a mystery card!\n",
            "You think I’ll just hand you victory? Dream on! New card, please!\n",
            "You think you’ve got me figured out? Not even close! Let’s shake things up with a new card!\n",
            "Sorry, but I'm allergic to losing. Let's grab a new card, shall we?\n",
            "It's all about perspective, isn't it? I see an opportunity for improvement. To the deck!\n",
            "You know what they say: out with the old, in with the... better! I'll take a new card.\n",
            "Decisions, decisions! But I think I'll spice things up by picking a shiny new card.\n",
            "A new card, you say? Don't mind if I do! Let's shake things up a bit.\n"
    };

    private final String[] CPU_RESPONSES_PLAYING = {
            "Whatever you thought, THINK AGAIN! Here’s something different.\n",
            "Don’t get too comfortable. I’m switching things up with this card.\n",
            "Variety is the spice of life, right? Here’s a different card to keep things spicy.\n",
            "Sorry, but the game’s not over until I say so. Here’s my next move.\n",
            "Oh you thought I'd say something annoying? Nope, just trying to play a civil game\n",
            "PIKACHU! I CHOOSE YOU! ...\n",
            "I suppose this will do\n",
            "I don't see you winning so it doesn't really matter what I put down\n",
            "Okay, I'm done...\n",
            "You should maybe play with real friends at some point\n",
            "How long do you plan on playing? Maybe call this quits and touch some grass...\n",
            "Don't think too hard about your next move, I never do.\n",
            "Let's see how this plays out\n",
            "I think I'll just play this one...\n",
            "You seem nervous...\n"
    };

    public ComputerPlayerBlackJack(List<Card> currentHandHand, Deck deck, String name) {
        super(currentHandHand);
        this.deck = deck;
        this.PICKUP_CARD = deck.dealCard(1);
        this.NAME = name;
    }

    public void setEndTurnEarly(boolean endTurnEarly) {
        this.endTurnEarly = endTurnEarly;
    }

    public void determinePlayableCards(List<Card> cpuHand, String cardSymbol, String cardSuit) {
        playableCards.clear();
        for (Card card : cpuHand) {
            if (card.getSymbol().equals(cardSymbol) || card.getSuit().equals(cardSuit)) {
                playableCards.add(card);
            }
        }
    }

//    public void playCardFromHand() {
//        System.out.println("\n " + NAME + " is thinking...");
//        Random random = new Random();
//        int randomIndex = random.nextInt(playableCards.size());
//        cpuPlayedCard = playableCards.get(randomIndex);
//        currentHand.remove(cpuPlayedCard);
//    }

    public List<Card> cpuTakeTurn(Card currentCard) {
        if (deck == null) {
            throw new IllegalStateException("Deck is not initialized");
        }

        playedCards.clear();
        String cardSymbol = currentCard.getSymbol();
        String cardSuit = currentCard.getSuit();

        determinePlayableCards(currentHand, cardSymbol, cardSuit);
        Random random = new Random();
        int randomIndex = random.nextInt(CPU_RESPONSES_PICKING.length);

        if (!playableCards.isEmpty()) {
            System.out.println("\n " + NAME + " is thinking...");
            int randomCardIndex = random.nextInt(playableCards.size());
            cpuPlayedCard = playableCards.get(randomCardIndex);
            currentHand.remove(cpuPlayedCard);
            playedCards.add(cpuPlayedCard);
            handlePowerCard(playedCards, currentCard);

            if (endTurnEarly) {
                return null;
            }

            System.out.println(CPU_RESPONSES_PLAYING[randomIndex]);
            System.out.println(NAME + " played: " + playedCards);
            BlackJackMain.setPickedUp(false);

        } else {
            System.out.println("\n " + NAME + " is thinking...");
            handlePowerCard(playedCards, currentCard);

            if (endTurnEarly) {
                BlackJackMain.setPickedUp(true);
                return null;
            }

            System.out.println(NAME + ": " + CPU_RESPONSES_PICKING[randomIndex]);
            addCardsToHand(PICKUP_CARD);
            System.out.println(NAME + " picked up a card.");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return playedCards;
    }

    private boolean isPowerCard(String symbol) {
        return "A".equals(symbol) || "Q".equals(symbol) ||
                "J".equals(symbol) || "2".equals(symbol);
    }

    public void handlePowerCard(List<Card> playedCards, Card currentCard) {
        System.out.println("Handle powerCard triggered");
        Random random = new Random();
        int randomIndex;
        Card extraCard;

        if (cpuPlayedCard != null && isPowerCard(cpuPlayedCard.getSymbol())) {
            if ("Q".equals(cpuPlayedCard.getSymbol()) || "A".equals(cpuPlayedCard.getSymbol())) {
                if (!currentHand.isEmpty()) {
                    randomIndex = random.nextInt(currentHand.size());
                    extraCard = currentHand.get(randomIndex);
                    currentHand.remove(extraCard);
                    playedCards.add(extraCard);
                    BlackJackMain.setPickedUp(false);
                } else {
                    addCardsToHand(PICKUP_CARD);
                    BlackJackMain.setPickedUp(true);
                }
            }
        } else if (isPowerCard(currentCard.getSymbol())) {
            System.out.println("Handle powerCard: checking card in play");
            System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
            if ("2".equals(currentCard.getSymbol())) {
                System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
                if (BlackJackMain.isPickedUp()) {
                    BlackJackMain.setPickedUp(false);
                } else {
                    System.out.println("I needed more cards anyway, thanks.");
                    addCardsToHand(deck.dealCard(2));
                    System.out.println(NAME + " picked up 2 cards");
                    setEndTurnEarly(true);
                    BlackJackMain.setPickedUp(true);
                }
            } else if ("J".equals(currentCard.getSymbol()) && ("Spades".equals(currentCard.getSuit()) || "Clubs".equals(currentCard.getSuit()))) {
                System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
                if (BlackJackMain.isPickedUp()) {
                    BlackJackMain.setPickedUp(false);
                } else {
                    // needs to know if player before picked up a card or not
                    System.out.println("I see my enemies are alive and well");
                    addCardsToHand(deck.dealCard(5));
                    System.out.println(NAME + " picked up 5 cards");
                    setEndTurnEarly(true);
                    BlackJackMain.setPickedUp(true);
                }
            }
        }
    }
}