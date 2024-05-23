package PapazKimde;


public class PapazKimde {

    // constants

    // variables
    private int numberOfPlayers;
    private Player player1;
//    private Deck gameDeck;

    public PapazKimde(int numberOfPlayers, Player player1 ) {
        this.numberOfPlayers = numberOfPlayers;
        this.player1 = player1;
    }

    public PapazKimde() {
    }
// get the whole deck, remove all kings but 1
    // > get deck, remove 3 K's
    // shuffle deck

    // deal the whole deck to the players
    // > some sort of array list for each player = their 'hand'

    // each player needs to go through their cards and remove any pairs
    // go through each card in list, if there's match in list, then remove
    // need to make sure it only removes pairs, not 3s

    // mimic player 1 pulling random card from player 2's deck -> ask for user input
    // "choose a card from player x's deck"
    // print the number of cards player x has ?

    // take in choice
    // check if any pairs, if pairs, remove, if no pairs, next player turn (computer or player2)
    // repeat

    // end game:
    // if only 2 players: one player reaches 0 cards in their list
    // if more than two players: total number of players -1 reaches 0 cards in their list
    // can make list of who finishes first

    // scoring: 2 player : winner = x points
    // 2 or more : first x points, second x-5 etc etc..
    // loser 0 points

    // potential classes:

    // game play/run through
    // userinteraction
    // userdisplay
    // user as computer ? -> or always have player 2, and if no player is entered, then default to computer
    // same for extra players -> if you want more players, you can add, if no information is given, default to computer
    // should define maximum number of players
}
