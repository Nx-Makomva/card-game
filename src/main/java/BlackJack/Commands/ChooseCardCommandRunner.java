package BlackJack.Commands;

import BlackJack.BlackJackMain;
import BlackJack.PlayerBlackJack.PlayerBlackJack;
import Card.Card;
import CommandRunner.CommandRunner;
import Deck.Deck;

import java.util.List;

public class ChooseCardCommandRunner extends CommandRunner {
//    private final Deck deck;
    private boolean userPickUpCard = false;
    private int userSelection;
    private String[] chooseCardCommands;
    private PlayerBlackJack currentPlayer;

    public ChooseCardCommandRunner(String[] chooseCardCommands, String title, PlayerBlackJack currentPlayer) {
        super(chooseCardCommands, "Picking a card");
        this.chooseCardCommands = chooseCardCommands;
        this.currentPlayer = currentPlayer;
//        this.deck = deck;
    }

    public void setChooseCardCommands(String[] newCommands) {
        this.chooseCardCommands = newCommands;
        this.commands = newCommands;
    }

    public List<String> resetCommands(List<String> cardStrings, List<Card> playableCards) {
        cardStrings.clear();
        for (Card card : playableCards) {
            cardStrings.add(card.toString());
        }
        cardStrings.add("Pick up a card");

        this.userPickUpCard = false;
        return cardStrings;
    }


//
//    public void handleUserPowerCardOptions(List<Card> playedCards, Card currentCard) {
//        if (isPowerCard(currentCard.getSymbol())) {
//            System.out.println("Handle powerCard: checking card in play");
//            System.out.println("pick up flag is: " + BlackJackMain.isPickedUp());
//            boolean hasCounterCard = playerHasCounterCard(playedCards, currentCard);
//            if (!hasCounterCard) {
//                System.out.println("You don't have a counter card, picking up cards...");
//                this.userPickUpCard = true;
//                if ("2".equals(currentCard.getSymbol())) {
//                    currentPlayer.addCardsToHand(deck.dealCard(2));
//                    System.out.println(currentPlayer.getName() + " picked up 2 cards.");
//                } else if ("J".equals(currentCard.getSymbol()) && ("Spades".equals(currentCard.getSuit()) || "Clubs".equals(currentCard.getSuit()))) {
//                    currentPlayer.addCardsToHand(deck.dealCard(5));
//                    System.out.println(currentPlayer.getName() + " picked up 5 cards.");
//                }
//            }
//        }
//    }
//
//    private boolean playerHasCounterCard(List<Card> playedCards, Card currentCard) {
//        for (Card card : playedCards) {
//            if (card.getSymbol().equals(currentCard.getSymbol()) || card.getSuit().equals(currentCard.getSuit())) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isPowerCard(String symbol) {
//        return "2".equals(symbol) || "8".equals(symbol) || "J".equals(symbol);
//    }


    @Override
    protected void handleUserSelection(int userSelection) {
        // method invoked to check if middle card is a power card and if it is, user turn ends early or they play again
        if (userSelection == this.commands.length) {
            printMessage("\n Picking up from the Deck...\n");
            this.userPickUpCard = true;
        } else {
            this.userSelection = userSelection;
        }
    }



    public boolean isPickingACard() {
        return userPickUpCard;
    }

    public int getUserSelection() {
        return userSelection;
    }

    @Override
    public void runCommands() {
        super.runCommands();
    }

}

