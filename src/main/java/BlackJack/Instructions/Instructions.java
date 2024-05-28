package BlackJack.Instructions;

public class Instructions {
    private String playerName;

    public Instructions(String playerName) {
        this.playerName = playerName;
    }

    public void showInstructions() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           Black Jack (no, not that one)        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Welcome to Black Jack, " + playerName + "!");
        System.out.println("Here are the instructions on how to play:");
        System.out.println();
        System.out.println("It's you vs the smart-mouthed computers.");
        System.out.println("You get dealt 7 cards to start and a random card is placed in the middle.");
        System.out.println("You need to match the middle card by suit or rank");
        System.out.println("Player to dealer's left goes first. They must follow suit or rank.");
        System.out.println();
        System.out.println("If any player cannot go, they pick up the top card from the deck.");
        System.out.println();
        drawPlayingCards();
        System.out.println("\nThe power cards are as follows:");
        System.out.println("- Aces change the suit and can be played on anything.");
        System.out.println("- Playing a two makes the next player skip their turn and pick up two instead, unless they can also play a two.");
        System.out.println("- Black Jacks make the next player pick up five cards.");
        System.out.println("  The only way to survive is to play a red Jack, which cancels out black Jacks but not twos.");
        System.out.println();
        System.out.println("And now for the final power card: the queen.");
        System.out.println("Whenever you lay a queen, you must cover her with another card, but it can be any card.");
        System.out.println("The objective is to get rid of your cards ASAP");
        System.out.println();
        System.out.println("Enjoy the game!\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private void drawPlayingCards() {
        System.out.println("        _____      _____      _____      _____ ");
        System.out.println("       |A    |    |2    |    |J    |    |Q    |");
        System.out.println("       |  ♦  |    |  ♣  |    |  ♠  |    |  ♥  |");
        System.out.println("       |____ |    |____ |    |____ |    |____ |");
    }
}
