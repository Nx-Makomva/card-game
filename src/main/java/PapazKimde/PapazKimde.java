package PapazKimde;

import Deck.Deck;
import Card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        // deal the whole deck to the players
        // > some sort of array list for each player = their 'hand'

    }




    public void playPapazKimde() {
        remove3Kings();
        numberOfPlayers = userInteraction.howManyPlayers();
        handleCreationOfUsers();
        System.out.println("Players:");
        for (Player player : players) {
            System.out.println(player);
        }
        // initial pair check

        ///// loop
        // method of pulling card from other player
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
