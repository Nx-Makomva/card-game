package BlackJack;

import BlackJack.Commands.ChooseCardCommandRunner;
import BlackJack.Instructions.Instructions;
import BlackJack.PlayerBlackJack.ComputerPlayerBlackJack;
import BlackJack.PlayerBlackJack.PlayerBlackJack;
import CommandRunner.WelcomeScreenCommands;
import Card.Card;
import Deck.Deck;

import java.util.ArrayList;
import java.util.Arrays;
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
        String playerName = PlayerBlackJack.setPlayerName();
        PlayerBlackJack player = new PlayerBlackJack(playerName, true, deck);
        Instructions instructions = new Instructions(playerName);
        WelcomeScreenCommands welcome = new WelcomeScreenCommands();
        welcome.runCommands();

        if (!welcome.shouldContinue()) {
            return;
        }

        instructions.showInstructions();

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

        // player should see picture cards eventually and not array of cards

        List<String> invalidCards = Arrays.asList("A", "K", "Q", "J", "2");
        List<Card> middleCard;
        do {
            middleCard = deck.dealCard(1);
        } while (invalidCards.contains(middleCard.get(0).getSymbol()));

        Card currentCard = middleCard.get(0);
        List<Card> playableCards = player.determinePlayableCards(playerHand, currentCard);

        List<String> cardStrings = new ArrayList<>();
        for (Card card : playableCards) {
            cardStrings.add(card.toString());
        }
        cardStrings.add("Pick up a card");

        String[] cardStringsArray = cardStrings.toArray(new String[0]);
        ChooseCardCommandRunner chooseCardCommandRunner = new ChooseCardCommandRunner(cardStringsArray, "Picking a card", player);

        boolean userTurnSkipped;
        do {
            System.out.print("\nThe card in the middle is: \n");
            System.out.println(currentCard = middleCard.get(middleCard.size() - 1));

            playerHand = player.getCurrentHand();
            playableCards = player.determinePlayableCards(playerHand, currentCard);

            List<String> resetCommands = chooseCardCommandRunner.resetCommands(cardStrings, playableCards);
            cardStringsArray = resetCommands.toArray(cardStrings.toArray(new String[0]));

            userTurnSkipped = false;

            if (currentCard.getSymbol().equals("J") && !pickedUp && (currentCard.getSuit().equals("Spades") || currentCard.getSuit().equals("Clubs"))) {
                boolean containsJack = false;
                for (Card card : playableCards) {
                    if (card.getSymbol().equals("J")) {
                        containsJack = true;
                        break;
                    }
                }
                if (!containsJack) {
                    player.addCardsToHand(deck.dealCard(5));
                    userTurnSkipped = true;

                }
                if (currentCard.getSymbol().equals("2") && !pickedUp) {
                    boolean containsTwo = false;
                    for (Card card : playableCards) {
                        if (card.getSymbol().equals("2")) {
                            containsTwo = true;
                            break;
                        }
                    }
                    if (!containsTwo) {
                        player.addCardsToHand(deck.dealCard(2));
                        userTurnSkipped = true;
                    }
                }
            }

            if (!playableCards.isEmpty() && !userTurnSkipped) {
                System.out.println("\n You current hand: " + playerHand);
                System.out.println("\nHint: ...you can play: " + playableCards);
                chooseCardCommandRunner.setChooseCardCommands(cardStringsArray);
                chooseCardCommandRunner.runCommands();

                boolean userPickingFromDeck = chooseCardCommandRunner.isPickingACard();
                int userChoice = chooseCardCommandRunner.getUserSelection() - 1;

                if (userPickingFromDeck) {
                    player.addCardsToHand(deck.dealCard(1));
                    pickedUp = true;
                    currentCard = middleCard.get(middleCard.size() - 1);
                    List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                    if (cpuOnePlayedCards != null) {
                        middleCard.addAll(cpuOnePlayedCards);
                        currentCard = middleCard.get(middleCard.size() - 1);
                    }

                    List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                    if (cpuTwoPlayedCards != null) {
                        middleCard.addAll(cpuTwoPlayedCards);
                    }

                } else {
                    player.playCardFromHand(userChoice, playableCards);
                    middleCard.add(player.getUserPlayedCard());
                    pickedUp = false;
                    currentCard = middleCard.get(middleCard.size() - 1);
                    List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                    if (cpuOnePlayedCards != null) {
                        middleCard.addAll(cpuOnePlayedCards);
                        currentCard = middleCard.get(middleCard.size() - 1);
                    }

                    List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                    if (cpuTwoPlayedCards != null) {
                        middleCard.addAll(cpuTwoPlayedCards);
                    }
                }
            } else {
                if (!userTurnSkipped) {
                System.out.println("\nIt's your turn but you can't play anything, you'll have to pick up a card");
                player.addCardsToHand(deck.dealCard(1));
                pickedUp = true;
                currentCard = middleCard.get(middleCard.size() - 1);
                List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                if (cpuOnePlayedCards != null) {
                    middleCard.addAll(cpuOnePlayedCards);
                    currentCard = middleCard.get(middleCard.size() - 1);
                }

                List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                if (cpuTwoPlayedCards != null) {
                    middleCard.addAll(cpuTwoPlayedCards);
                }
            }
        }
            if (userTurnSkipped) {
                currentCard = middleCard.get(middleCard.size() - 1);
                List<Card> cpuOnePlayedCards = cpuOne.cpuTakeTurn(currentCard);
                if (cpuOnePlayedCards != null) {
                    middleCard.addAll(cpuOnePlayedCards);
                    currentCard = middleCard.get(middleCard.size() - 1);
                }

                List<Card> cpuTwoPlayedCards = cpuTwo.cpuTakeTurn(currentCard);
                if (cpuTwoPlayedCards != null) {
                    middleCard.addAll(cpuTwoPlayedCards);
                }
            }

            if (playerHand.isEmpty() || cpuOneHand.isEmpty() || cpuTwoHand.isEmpty()) {
                gameOver = true;
                if (playerHand.isEmpty()) {
                    System.out.println("Congratulations, you managed to come out on top!");
                } else {
                    System.out.println("You hand: " + playerHand + "\n CPU One hand: " + cpuOneHand + "\n CPU Two hand: " + cpuTwoHand);
                    System.out.println("Tough break, you were never gonna beat us anyways. Go outside, touch some grass");
                }
            }
        } while (!gameOver);
    }
}

