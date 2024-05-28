package BlackJack.Instructions;

public class Instructions {

    public Instructions(String playerName) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║           Black Jack (no, not that one)           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("Welcome to Black Jack, " + playerName + "!");
        System.out.println("Here are the instructions on how to play:");
        System.out.println();
        System.out.println("It's you vs the smart-mouthed computers. You get dealt 7 cards to start and a random card is placed in the middle to start.");
        System.out.println("You need to match the middle card by suit or number");
        System.out.println("Player to dealer's left goes first.");
        System.out.println("They must follow suit or rank, but each player can lay as long a chain or run as they can,");
        System.out.println("providing the card ranks match as you jump from suit to suit.");
        System.out.println("For example, if the discard is five hearts, you can play a run such as:");
        System.out.println("five spades, six spades, six clubs, six diamonds, seven diamonds, seven clubs.");
        System.out.println("If any player cannot go, they pick up the top card from the discard pile.");
        System.out.println();
        drawPlayingCards();
        System.out.println("The power cards are as follows:");
        System.out.println("- Aces change the suit and can be played on anything.");
        System.out.println("- Playing a two makes the next player skip their turn and pick up two instead, unless they can also play a two.");
        System.out.println("- Black Jacks make the next player pick up five cards.");
        System.out.println("  The only way to survive is to play a red jack, which cancels out black jacks but not twos.");
        System.out.println();
        System.out.println("And now for the final power card: the queen.");
        System.out.println("Whenever you lay a queen, you must cover her with another card, but it can be any card.");
        System.out.println("The object is to get rid of your cards ASAP");
        System.out.println();
        System.out.println("Enjoy the game!");
        System.out.println();
    }

    private void drawPlayingCards() {
        System.out.println("        _____      _____      _____ ");
        System.out.println("       |Q    |    |J    |    |2    |");
        System.out.println("       |  ♦  |    |  ♠  |    |  ♠  |");
        System.out.println("       |____ |    |____ |    |____ |");
    }
}
