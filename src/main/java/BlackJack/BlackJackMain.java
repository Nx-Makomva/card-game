package BlackJack;


import BlackJack.Commands.ChooseCardCommandRunner;
import BlackJack.PlayerBlackJack.ComputerPlayerBlackJack;
import BlackJack.PlayerBlackJack.PlayerBlackJack;
import CommandRunner.WelcomeScreenCommands;
import Player.Player;
import Player.ComputerPlayer;
import Card.Card;
import Deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class BlackJackMain {

    private static boolean gameOver = true;
    private static boolean computerTurn = false;
    private static boolean playerTurn = true;

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        BlackJackMain.gameOver = gameOver;
    }

    public static void startGame() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        // new instance of scanner here to grab users name
        PlayerBlackJack player = new PlayerBlackJack("", true);

        WelcomeScreenCommands welcome = new WelcomeScreenCommands();
        welcome.runCommands();

        // Things I need:
        // - a wallet for the user's money amount
        // - display class to show user their cards


        System.out.println("Welcome to black jack\n"); // eventually move this to a welcome screen - possibly one that reroutes from welcome command screen


        List<Card> playerHand = new ArrayList<>();
        List<Card> cpuOneHand = new ArrayList<>();
        List<Card> cpuTwoHand = new ArrayList<>();


        for (int i = 0; i < 7; i++) {
            playerHand.add(deck.dealCard(1).get(0));
            cpuOneHand.add(deck.dealCard(1).get(0));
            cpuTwoHand.add(deck.dealCard(1).get(0));
        }

        ComputerPlayerBlackJack cpuOne = new ComputerPlayerBlackJack(cpuOneHand);
        ComputerPlayerBlackJack cpuTwo = new ComputerPlayerBlackJack(cpuTwoHand);
        player.setCurrentHand(playerHand);

        System.out.println("Here are your cards: \n " + player.getCurrentHand());

        // player should see picture cards eventually and not array of cards

        // 1 card should be dealt in the middle, to begin, but it can't be Ace, J, Q or K

        List<Card> playingCard = deck.dealCard(1); // can this be merged into one line with bottom line?
        Card currentCard = playingCard.get(0);
        int cardValue = currentCard.getValue();
        String cardSuit = currentCard.getSuit();


        System.out.println("\nFirst playing card is " + playingCard);

        List<Card> playableCards = player.determinePlayableCards(playerHand, cardValue, cardSuit);

        List<String> cardStrings = new ArrayList<>();
        for (Card card : playableCards) {
            cardStrings.add(card.toString());
        }
        cardStrings.add("Pick up a card");

        String[] cardStringsArray = cardStrings.toArray(new String[0]);
        ChooseCardCommandRunner chooseCardCommandRunner = new ChooseCardCommandRunner(cardStringsArray, "Picking a card");

        do {
            // run player turn at the start of each loop. turn terminates when choice is made
            //  could just have a boolean flag to tell if its user turn or not
            playerTurn = true;
            computerTurn = false;

            currentCard = playingCard.get(playingCard.size() - 1);
            cardValue = currentCard.getValue();
            cardSuit = currentCard.getSuit();
            playerHand = player.getCurrentHand();
            playableCards = player.determinePlayableCards(playerHand, cardValue, cardSuit);

            List<String> resetCommands = chooseCardCommandRunner.resetCommands(cardStrings, playableCards);
            cardStringsArray = resetCommands.toArray(cardStrings.toArray(new String[0]));

            chooseCardCommandRunner.setChooseCardCommands(cardStringsArray);

            if (!playableCards.isEmpty()) {
                System.out.println("\nHint: ...you can play: " + playableCards);
                chooseCardCommandRunner.runCommands();

                boolean userPickingFromDeck = chooseCardCommandRunner.isPickingACard();
                int userChoice = chooseCardCommandRunner.getUserSelection() - 1;

                if (userPickingFromDeck) {
                    List<Card> newCard = deck.dealCard(1);
                    player.addCardsToHand(newCard);
                    playerTurn = false;
                    computerTurn = true;
                    // turn ends here and it should go back to computer turn
                    // run computer turn
                } else {
                    player.playCardFromHand(userChoice, playableCards);
                    playingCard.add(player.getUserPlayedCard());
                    playerTurn = false;
                    computerTurn = true;
//                    System.out.println("\nLast Played card: " + playingCard.get(playingCard.size() - 1));
                    // turn ends here and it should go back to computer turn
                }
            } else {
                System.out.println("No luck, you'll have to pick up a card");
                List<Card> pickUpCard = deck.dealCard(1);
                player.addCardsToHand(pickUpCard);
                playerTurn = false;
                computerTurn = true;
                // turn ends here and it should go back to computer turn
            }

            // have a player class that takes in cards and accumulates the value of those cards.
            // If they go above 21 then they bust. If below 17 then they must keep drawing
        } while (!gameOver);

    }
}
