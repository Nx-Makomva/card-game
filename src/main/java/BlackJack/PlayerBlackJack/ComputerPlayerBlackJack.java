package BlackJack.PlayerBlackJack;

import BlackJack.BlackJackMain;
import Card.Card;
import Player.ComputerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayerBlackJack extends ComputerPlayer {
    private String suit;
    private String symbol;
    protected Card cpuPlayedCard = null;
    List<Card> playedCards = new ArrayList<>();
    List<Card> playableCards = new ArrayList<>();
    String[] cpuResponsesPicking = {
            "This card’s not for you just yet. Let’s see what else I can pick up.\n",
            "Why reveal my hand when I can draw a mystery card?\n",
            "Strategically, it's better to hold this one and see what the deck offers.\n",
            "I think I’ll just keep you in suspense and draw a new card.\n",
            "I’m not about to make your life easy. Drawing a new card!\n",
            "Like I’d play this one right now. I’ll draw instead.\n",
            "Let’s keep things interesting. Drawing a new card!\n",
            "Guess what? I'm feeling mischievous today. Let's swap this for a mystery card!\n",
            "You think I’ll just hand you victory? Dream on! New card, please!\n",
            "You think you’ve got me figured out? Not even close! Let’s shake things up with a new card!\n",
            "Sorry, but I'm allergic to losing. Let's grab a new card, shall we?\n",
            "It's all about perspective, isn't it? I see an opportunity for improvement. To the deck!\n",
            "You know what they say: out with the old, in with the... better! I'll take a new card.\n",
            "Decisions, decisions! But I think I'll spice things up with a shiny new card.\n",
            "A new card, you say? Don't mind if I do! Let's shake things up a bit.\n"
    };

    String[] cpuResponsesPlaying = {
            "Whatever you thought, THINK AGAIN! Here’s something different.\n",
            "Don’t get too comfortable. I’m switching things up with this card.\n",
            "Variety is the spice of life, right? Here’s a different card to keep things spicy.\n",
            "Sorry, but the game’s not over until I say so. Here’s my next move.\n",
            "Oh you thought I'd say something annoying? Nope, just trying to play a civil game\n",
            "PIKACHU! I CHOOSE YOU! ...\n",
            "I suppose this will do\n",
            "I don't see you winning so it doesn't really matter what I put down\n",
            "Okay, I'm done.. your turn\n",
            "You should maybe play with real friends at some point\n",
            "How long do you plan on playing? Maybe call this quits and touch some grass...\n",
            "Don't think too hard about your next move, I never do.\n",
            "Let's see how this plays out\n",
            "I think I'll just play this one...\n",
            "You seem nervous...\n"
    };

    // update cpu current hand

    public ComputerPlayerBlackJack(List<Card> currentHandHand) {
        super(currentHandHand);
    }

    public void determinePlayableCards(List<Card> cpuHand, int cardValue, String cardSuit) {
        playableCards.clear();
        for (Card card : cpuHand) {
            if (card.getValue() == cardValue || card.getSuit().equals(cardSuit)) {
                playableCards.add(card);
            }
        }
    }

//    public Card getCpuPlayedCard() {
//        try {
//            Thread.sleep(3000);
//            System.out.println("I played: " + cpuPlayedCard);
//            return cpuPlayedCard;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public void playCardFromHand() {
        System.out.println("\nCPU is thinking...");
        Random random = new Random();
        int randomIndex = random.nextInt(playableCards.size());
        cpuPlayedCard = playableCards.get(randomIndex);
        currentHand.remove(cpuPlayedCard);
    }

    public List<Card> cpuTakeTurn(int cardValue, String cardSuit, String cardSymbol, List<Card> pickUpCard) {
        playedCards.clear();
        this.suit = cardSuit;
        this.symbol = cardSymbol;

        BlackJackMain.setComputerTurn(true);
        BlackJackMain.setPlayerTurn(false);

        determinePlayableCards(currentHand, cardValue, cardSuit);
        Random random = new Random();
        int randomIndex = random.nextInt(cpuResponsesPicking.length);

        if (!playableCards.isEmpty()) {
            playCardFromHand();
            System.out.println(cpuResponsesPlaying[randomIndex]);
            playedCards.add(cpuPlayedCard);
            handlePowerCard(playedCards);
            System.out.println("I played: " + playedCards);
        } else {
            System.out.println("\nCPU is thinking...");
            System.out.println(cpuResponsesPicking[randomIndex]);
            addCardsToHand(pickUpCard);
        }

        BlackJackMain.setComputerTurn(false);

        // ADD ANOTHER CHECK HERE TO SEE WHAT CARD CPU PICKED.
        // IF CARD IS A, Q, K, J (RED & BLACK) THEN SOMETHING HAPPENS
        // WRITE THIS IN ANOTHER METHOD AND THEN INVOKED THIS METHOD HERE IN THE "TAKE TURN" METHOD

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return playedCards;
    }

    private boolean isPowerCard(String symbol) {
        return "A".equals(symbol) || "K".equals(symbol) || "Q".equals(symbol) ||
                "J".equals(symbol) || "8".equals(symbol) || "2".equals(symbol);
    }

    public void handlePowerCard(List<Card> playedCards) {
        Random random = new Random();
        int randomIndex = random.nextInt(currentHand.size());
        if (isPowerCard(cpuPlayedCard.getSymbol())) {
            if ("Q".equals(cpuPlayedCard.getSymbol())) {
                Card extraCard = currentHand.get(randomIndex);
                System.out.println("I played a " + cpuPlayedCard + ", so my extra card is a: " + extraCard);
                currentHand.remove(extraCard);
                playedCards.add(extraCard);
            }
        }
    }
}
