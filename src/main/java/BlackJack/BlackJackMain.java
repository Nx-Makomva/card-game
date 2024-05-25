package BlackJack;


import BlackJack.Commands.ChooseCardCommandRunner;
import CommandRunner.WelcomeScreenCommands;
import Player.Player;
import Player.ComputerPlayer;
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
        Player player = new Player("", true);

        WelcomeScreenCommands welcome = new WelcomeScreenCommands();
        welcome.runCommands();

        // Things I need:
        // - a wallet for the user's money amount
        // - display class to show user their cards and the dealer cards


        System.out.println("Welcome to black jack"); // eventually move this to a welcome screen - possibly one that reroutes from welcome command screen
        System.out.println("Here are your cards");

        List<Card> playerHand = new ArrayList<>();
        List<Card> cpuOneHand = new ArrayList<>();
        List<Card> cpuTwoHand = new ArrayList<>();


        for (int i = 0; i < 7; i++) {
            playerHand.add(deck.dealCard(1).get(0));
            cpuOneHand.add(deck.dealCard(1).get(0));
            cpuTwoHand.add(deck.dealCard(1).get(0));
        }

        ComputerPlayer cpuOne = new ComputerPlayer(cpuOneHand);
        ComputerPlayer cpuTwo = new ComputerPlayer(cpuTwoHand);
        player.setCurrentHand(playerHand);


        System.out.println("Player current hand is: " + player.getCurrentHand());

        // player should see picture cards eventually and not array of cards

        // 1 card should be dealt in the middle, to begin, but it can't be Ace, J, Q or K
        List<Card> playingCard = deck.dealCard(1); // can this be merged into one line with bottom line?
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

        List<String> cardStrings = new ArrayList<>();
        for (Card card : playableCards) {
            cardStrings.add(card.toString());
        }
        cardStrings.add("Pick up a card");

        String[] cardStringsArray = cardStrings.toArray(new String[0]);


        ChooseCardCommandRunner chooseCardCommandRunner = new ChooseCardCommandRunner(cardStringsArray, "Picking a card");


        if (!playableCards.isEmpty()) {
            System.out.println("Hey, you can play: " + playableCards);
            // run a card selection command runner that takes user choice and executes it
            // - playable cards needs to be given as the commands
            // run a class - probs in player that selects the card that has been chosen
            // and choice of input here for them to choose which card to play
            chooseCardCommandRunner.runCommands();// CAN I GET choose card command runner to return info about user selection? then i can use that info to do Player.addCradstoHand method
            boolean userPickingFromDeck = chooseCardCommandRunner.isPickingACard();
            int userChoice = chooseCardCommandRunner.getUserSelection() - 1;
            if (userPickingFromDeck) {
                List<Card> newCard = deck.dealCard(1);
                player.addCardsToHand(newCard);
                System.out.println("You drew: " + newCard);
                System.out.println(player.getCurrentHand());
                // turn ends here and it should go back to computer turn
            } else {
                player.playCardFromHand(userChoice, playableCards);
                playingCard.add(player.getUserPlayedCard());
                System.out.println("Last Played card: " + playingCard.get(playingCard.size() - 1));
            }
        } else {
                System.out.println("No luck, you'll have to pick up a card");
                List<Card> pickUpCard = deck.dealCard(1);
                player.addCardsToHand(pickUpCard);
                System.out.println("You picked up: " + pickUpCard);
                System.out.println("Your new hand is: " + player.getCurrentHand());
            }

            do {

                // have a player class that takes in cards and accumulates the value of those cards.
                // If they go above 21 then they bust. If below 17 then they must keep drawing
            } while (!GameOver);

        }
    }
