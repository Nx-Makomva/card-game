package BlackJack;


import CommandRunner.WelcomeScreenCommands;
import ComputerPlayer.ComputerPlayer;
import Player.Player;
import Card.Card;
import Deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class BlackJackMain {

    private static boolean GameOver = true;

    public static boolean isGameOver() {
        return GameOver;
    }

    public static void setGameOver(boolean gameOver) {
        GameOver = gameOver;
    }

    public static void startGame() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        // new instance of scanner here to grab users name
        Player player = new Player("");

        WelcomeScreenCommands welcome = new WelcomeScreenCommands();
        welcome.runCommands();

        // run commands here: - where scanner stuff is to take and store input
        // 1. welcome player to the game
        // 2. ask them if they want to continue playing or quit
        // 3. If they continue to play then run the welcome screen + instructions on how to play
        // e.g. aim of the game, the amount of money they start with - that they can bet etc.
        // 4. run actual game.

        // Things I need:
        // - a wallet for the user's money amount
        // - display class to show user their cards and the dealer cards
        // - player class
        // - dealer class

        System.out.println("Welcome to black jack");
        System.out.println("Here are your cards");

        List<Card> playerHand = new ArrayList<>();
        List<Card> cpuOneHand = new ArrayList<>();
        List<Card> cpuTwoHand = new ArrayList<>();


        for (int i = 0; i < 7; i++) {
            playerHand.add(deck.dealCard(1).get(0));
            cpuOneHand.add(deck.dealCard(1).get(0));
            cpuTwoHand.add(deck.dealCard(1).get(0));
        }


//        playerHand = deck.dealCard(7);
//        cpuOneHand = deck.dealCard(7);
//        cpuTwoHand = deck.dealCard(7);


        ComputerPlayer cpuOne = new ComputerPlayer(cpuOneHand);
        ComputerPlayer cpuTwo = new ComputerPlayer(cpuTwoHand);
        player.setCurrentHand(playerHand);


        System.out.println("Player current hand is: " + player.getCurrentHand());
        System.out.println("CPUOne current hand is: " + cpuOne.getCurrentHand());
        System.out.println("CPUTwo current hand is: " + cpuTwo.getCurrentHand());

        // player should see picture cards eventually and not array of cards

        // 1 card should be dealt in the middle, to begin, but it can't be Ace, J, Q or K
        List<Card> playingCard = deck.dealCard(1);
            Card currentCard = playingCard.get(0);
            int cardValue = currentCard.getValue();
            String cardSuit = currentCard.getSuit();


        System.out.println("First playing card is " + playingCard);

        // now need to do a check for the user to see if any of the cards in their hand matches
        // the current card being played (might need a list - "discard pile" where played cards go so
        // can easily check the last played card). if player has playable card according to suit or value then
        // computer prompts them to choose one of the playable cards in their hand. If they have nothing then
        // deck.dealCard(1) is executed. This basic part will loop until end of game.

        // Player turns - after player turn ends then it's time for cpu turns to execute


        List<Card> playableCards = new ArrayList<>();

        for (Card card : playerHand) {
            if (card.getValue() == cardValue || card.getSuit().equals(cardSuit)) {
                playableCards.add(card);
            }
        }


        if (!playableCards.isEmpty()) {
            System.out.println("Hey, you can play: " + playableCards);
            // and choice of input here for them to choose which card to play
        } else {
            System.out.println("No luck, you'll have to pick up a card");
            List<Card> pickUpCard = deck.dealCard(1);
            player.addCardsToHand(pickUpCard);
            System.out.println("You picked up: " + pickUpCard);
            System.out.println("Your new hand is: " + player.getCurrentHand());
        }

//
//        System.out.println("card numbers are: " + cardNumbers);
//        System.out.println("card suits are: " + cardSuits);

        do {

            // have a player class that takes in cards and accumulates the value of those cards.
            // If they go above 21 then they bust. If below 17 then they must keep drawing
        } while (!GameOver);

    }
}
