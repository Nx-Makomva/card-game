package BlackJack;


import BlackJack.Commands.ChooseCardCommandRunner;
import BlackJack.PlayerBlackJack.ComputerPlayerBlackJack;
import BlackJack.PlayerBlackJack.PlayerBlackJack;
import CommandRunner.WelcomeScreenCommands;
import Card.Card;
import Deck.Deck;

import java.util.ArrayList;
import java.util.List;

public class BlackJackMain {

    private static boolean gameOver = true;
    private static boolean pickedUp = false;




    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        BlackJackMain.gameOver = gameOver;
    }

    public static boolean isPickedUp() {
        return pickedUp;
    }

    public static void setPickedUp(boolean pickedUp) {
        BlackJackMain.pickedUp = pickedUp;
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

        ComputerPlayerBlackJack cpuOne = new ComputerPlayerBlackJack(cpuOneHand, deck, "CPU One");
        ComputerPlayerBlackJack cpuTwo = new ComputerPlayerBlackJack(cpuTwoHand, deck, "CPU Two");
        player.setCurrentHand(playerHand);

        System.out.println("Here are your cards: \n " + player.getCurrentHand());

        // player should see picture cards eventually and not array of cards

        // 1 card should be dealt in the middle, to begin, but it can't be A, J, Q or K

        List<Card> playingCard = deck.dealCard(1);

        Card currentCard = playingCard.get(0);

        List<Card> playableCards = player.determinePlayableCards(playerHand, currentCard);

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

            System.out.print("\nThe card in the middle is: \n");
            System.out.println(currentCard = playingCard.get(playingCard.size() - 1));

            playerHand = player.getCurrentHand();
            playableCards = player.determinePlayableCards(playerHand, currentCard);

            List<String> resetCommands = chooseCardCommandRunner.resetCommands(cardStrings, playableCards);
            cardStringsArray = resetCommands.toArray(cardStrings.toArray(new String[0]));

            chooseCardCommandRunner.setChooseCardCommands(cardStringsArray);

            if (!playableCards.isEmpty()) {
                System.out.println("\nHint: ...you can play: " + playableCards);
                chooseCardCommandRunner.runCommands();

                boolean userPickingFromDeck = chooseCardCommandRunner.isPickingACard();
                int userChoice = chooseCardCommandRunner.getUserSelection() - 1;

                if (userPickingFromDeck) {
                    player.addCardsToHand(deck.dealCard(1));
                    pickedUp = true;
                    currentCard = playingCard.get(playingCard.size() - 1);
                    List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                    if (cpuOnePlayedCards != null ) {
                        playingCard.addAll(cpuOnePlayedCards);
                        currentCard = playingCard.get(playingCard.size() - 1);
                    }

                    List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                    if (cpuTwoPlayedCards != null ) {
                        playingCard.addAll(cpuTwoPlayedCards);
                    }

                } else {
                    player.playCardFromHand(userChoice, playableCards);
                    playingCard.add(player.getUserPlayedCard());
                    pickedUp = false;
                    currentCard = playingCard.get(playingCard.size() - 1);
                    List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                    if (cpuOnePlayedCards != null ) {
                        playingCard.addAll(cpuOnePlayedCards);
                        currentCard = playingCard.get(playingCard.size() - 1);
                    }

                    List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                    if (cpuTwoPlayedCards != null ) {
                        playingCard.addAll(cpuTwoPlayedCards);
                    }

                }
            } else {
                System.out.println("\nIt's your turn but you can't play anything, you'll have to pick up a card");
                player.addCardsToHand(deck.dealCard(1));
                pickedUp = true;
                currentCard = playingCard.get(playingCard.size() - 1);
                List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                if (cpuOnePlayedCards != null ) {
                    playingCard.addAll(cpuOnePlayedCards);
                    currentCard = playingCard.get(playingCard.size() - 1);
                }

                List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                if (cpuTwoPlayedCards != null ) {
                    playingCard.addAll(cpuTwoPlayedCards);
                }
            }
        } while (!gameOver);

    }
}
