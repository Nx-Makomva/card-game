package BlackJack;


import BlackJack.CommandRunner.WelcomeScreenCommands;
import BlackJack.Player.Player;
import Deck.Deck;

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

        do {

            // have a player class that takes in cards and accumulates the value of those cards.
            // If they go above 21 then they bust. If below 17 then they must keep drawing
        } while (!GameOver);

    }

}
