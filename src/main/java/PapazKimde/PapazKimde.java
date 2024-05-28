package PapazKimde;

import Deck.Deck;
import Card.Card;
import Player.Player;
import Player.ComputerPlayer;


import java.util.ArrayList;
import java.util.List;
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

    public void playPapazKimde() {
        remove3Kings();
        numberOfPlayers = userInteraction.howManyPlayers();
        handleCreationOfUsers();
        System.out.println("Players:");
        deckDeal();
        for (Player player : players) {
            System.out.println(player);
            System.out.println("initial hand: " + player.getCurrentHand());
        }

        // initial pair check and removal
        for (Player player : players) {
            player.pairRemoval();
            System.out.println("pair removal : " + player.getCurrentHand());
        }

        ///// loop
        // method of pulling card from other player
        // for human player, prompt which card they want to pull from next player
        // you're pulling from so and so's deck, they have 9 cards, pick a number from 1-9 to pick one of their cards
        // process input -> whatever card they've chosen, remove it from the player's hand and add it to their hand
        // also sout "you have taken whatever from so and so's deck"
        // for computer player, randomly select card from next person and ig print out "computer x has played their turn when it is over"
        // method of check if any pairs, if pairs, remove, if no pairs, next player turn (computer or player2)
        // repeat

        // end game:
        // if only 2 players: one player reaches 0 cards in their list
        // if more than two players: total number of players -1 reaches 0 cards in their list
        // can make list of who finishes first


    }

    // potential classes:

    // game play/run through
    // userinteraction
    // userdisplay
    // user as computer ? -> or always have player 2, and if no player is entered, then default to computer
    // same for extra players -> if you want more players, you can add, if no information is given, default to computer
    // should define maximum number of players
}
