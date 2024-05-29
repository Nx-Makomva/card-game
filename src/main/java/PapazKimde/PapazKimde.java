package PapazKimde;

import CommandRunner.ReplayGameCommandRunner;
import Deck.Deck;
import Card.Card;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class PapazKimde {

    // constants

    // variables
    private int numberOfPlayers;
    private Deck gameDeck;
    private UserInteraction userInteraction;
    private List<Player> players;

    public PapazKimde(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.gameDeck = new Deck();
        this.userInteraction = new UserInteraction();
        this.players = new ArrayList<>();
    }

    public PapazKimde() {
        this.gameDeck = new Deck();
        this.userInteraction = new UserInteraction();
        this.players = new ArrayList<>();
    }

    public void remove3Kings() {
        List<Card> cards = gameDeck.getDeckOfCards();

        // removing all kings
        List<Card> nonKingCards = cards.stream()
                .filter(card -> !card.isKing())
                .collect(Collectors.toList());

        // get one king
        Card remainingKing = cards.stream()
                .filter(card -> card.isKing())
                .findAny()
                .orElseThrow();

        // add it back
        nonKingCards.add(remainingKing);

        // create new deck with filtered cards
        Deck playingDeck = new Deck(nonKingCards);

        // shuffle this new deck
        playingDeck.shuffleDeck();

        // update the deck above
        this.gameDeck = playingDeck;
    }

    public void handleCreationOfUsers() {
        // player 1 is always a human
        System.out.println("Enter name for player 1:");
        String nameForPlayer1 = userInteraction.getUserInput();
        players.add(new Player(nameForPlayer1, true));

        // creating rest of players
        for (int i = 2; i <= numberOfPlayers; i++) {
            System.out.println("Is player " + i + " a human? (yes/no)");
            boolean isHuman = userInteraction.isHumanPlayer();
            String name;
            if (isHuman) {
                System.out.println("Enter name for player " + i + ":");
                name = userInteraction.getUserInput();
            } else {
                name = "Computer" + i;
            }
            players.add(new Player(name, isHuman));
        }
    }

    public void deckDeal() {
        int currentPlayerIndex = 0;
        while (!gameDeck.getDeckOfCards().isEmpty()) {
            Card dealtCard = gameDeck.dealCard(1).get(0);
            players.get(currentPlayerIndex).addCardsToHand(List.of(dealtCard));
            currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
        }
    }

    public Card pullCardFromPlayer(Player currentPlayer, Player targetPlayer, boolean isHuman) {
        Random random = new Random();
        Card pulledCard = null;

        if (isHuman) {
            Scanner scanner = new Scanner(System.in);
            int cardIndex = -1; // Initialize cardIndex

            // Loop until a valid card index is provided by the user
            while (true) {
                System.out.println("Your current hand: \n" );
                currentPlayer.printHandVisual(currentPlayer.getCurrentHand());
                System.out.println("\nYou're pulling from " + targetPlayer.getName() + "'s deck. " +
                        "They have " + targetPlayer.getCurrentHand().size() + " cards.");
                System.out.println("\nPick a number from 1 to " + targetPlayer.getCurrentHand().size() + " to choose a card");

                // Ensure the input is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + targetPlayer.getCurrentHand().size());
                    scanner.next(); // Consume invalid input
                }

                cardIndex = scanner.nextInt() - 1; // Convert to zero-based index

                // Check if the cardIndex is within valid range
                if (cardIndex >= 0 && cardIndex < targetPlayer.getCurrentHand().size()) {
                    break; // Exit the loop if the index is valid
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + targetPlayer.getCurrentHand().size());
                }
            }

            pulledCard = targetPlayer.getCurrentHand().remove(cardIndex);
            System.out.println("\nYou've taken " + pulledCard + " from " + targetPlayer.getName() + "'s deck.");
        } else {
            try {
                // Add a delay of, for example, 2 seconds (2000 milliseconds)
                TimeUnit.SECONDS.sleep(3);
                // For computer players, randomly select a card from targetPlayer's hand
                int cardIndex = random.nextInt(targetPlayer.getCurrentHand().size());
                pulledCard = targetPlayer.getCurrentHand().remove(cardIndex);
                System.out.println(currentPlayer.getName() + " pulled a card from " + targetPlayer.getName());
            } catch (InterruptedException e) {
                // Handle the exception, if needed
                e.printStackTrace();
            }

        }
        return pulledCard;
    }


    public void playPapazKimde() {
        remove3Kings();
        numberOfPlayers = userInteraction.howManyPlayers();
        handleCreationOfUsers();
        deckDeal();

        // initial pair check and removal
        for (Player player : players) {
            player.pairRemoval();
        }

        boolean gameInProgress = true;

        while (gameInProgress) {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                // skip player if no cards
                if (currentPlayer.getCurrentHand().isEmpty()) {
                    continue;
                }

                Player targetPlayer = players.get((i + 1) % players.size());
                if (targetPlayer.getCurrentHand().isEmpty()) {
                    continue;
                }

                Card pulledCard = pullCardFromPlayer(currentPlayer, targetPlayer, currentPlayer.isHuman());
                currentPlayer.addCardsToHand(List.of(pulledCard));
                currentPlayer.pairRemoval();
                if (currentPlayer.isHuman()){
                    System.out.println("Your current hand:");
                    currentPlayer.printHandVisual(currentPlayer.getCurrentHand());
                }


                if (currentPlayer.getCurrentHand().isEmpty()) {
                    System.out.println(currentPlayer.getName() + " has finished their cards.");
                }

                // Check if the game should continue
                long activePlayers = players.stream().filter(p -> !p.getCurrentHand().isEmpty()).count();
                if (activePlayers <= 1) {
                    gameInProgress = false;
                    System.out.println("Game Over! The final standings are:");
                    players.forEach(player -> System.out.println(player.getName() + " has " + player.getCurrentHand().size() + " cards left."));
                    ReplayGameCommandRunner replayGameCommandRunner = new ReplayGameCommandRunner();
                    replayGameCommandRunner.runCommands();
                    break;
                }
            }


        }

        // potential classes:

        // game play/run through
        // userinteraction
        // userdisplay
        // user as computer ? -> or always have player 2, and if no player is entered, then default to computer
        // same for extra players -> if you want more players, you can add, if no information is given, default to computer
        // should define maximum number of players
    }
}
