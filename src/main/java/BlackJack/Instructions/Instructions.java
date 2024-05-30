package BlackJack.Instructions;

import Utils.ColorUtils;

public class Instructions {
    private String playerName;

    public Instructions(String playerName) {
        this.playerName = playerName;
    }

    public void showInstructions() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           Black Jack (no, not that one)        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(ColorUtils.ORANGE + "Welcome to Black Jack, " + playerName + "!" + ColorUtils.RESET);
        System.out.println("Here are the instructions on how to play:");
        System.out.println();
        System.out.println("It's you vs the smart-mouthed computers.");
        System.out.println("You get dealt 7 cards to start and a random card is placed in the middle.");
        System.out.println("You need to match the middle card by suit or rank");
        System.out.println("You get to start first, lucky you...");
        System.out.println();
        System.out.println("If you or the bots cannot go, a card will be added to that player's hand.");
        System.out.println();
        drawPlayingCards();
        System.out.println("\nThe power cards are as follows:");
        System.out.println("- Aces change the suit and can be played on anything.");
        System.out.println("- Playing a two makes the next player skip their turn and pick up two instead, unless they can also play a two.");
        System.out.println(ColorUtils.BLUE + "- Black Jacks (blue, in this game) " + ColorUtils.RESET + "make the next player pick up five cards.");
        System.out.println("  The only way to survive is to play a " + ColorUtils.RED + "red Jack " + ColorUtils.RESET + ", which cancels out black Jacks but not twos.");
        System.out.println();
        System.out.println("And now for the final power card: the queen.");
        System.out.println("Whenever you lay a queen, you must cover her with another card, but it can be any card.");
        System.out.println();
        System.out.println("The objective is to get rid of your cards ASAP.");
        System.out.println();
        System.out.println(ColorUtils.ORANGE + "P.S: The computers rigged the game in favour of them, sorry... I don't make the rules.");
        System.out.println(ColorUtils.ORANGE + "Every time they play a Q or A they get to play again, you do NOT have this privilege.");
        System.out.println(ColorUtils.RESET);
        System.out.println("Have fun!");
        System.out.println();
        System.out.println(ColorUtils.ORANGE + "\nGAME HAS BEGUN!" + ColorUtils.RESET);
    }

    private void drawPlayingCards() {
        System.out.println("        _____      _____      _____      _____ ");
        System.out.println("       |A    |    |2    |    |J    |    |Q    |");
        System.out.println("       |  ♦  |    |  ♣  |    |  ♠  |    |  ♥  |");
        System.out.println("       |____ |    |____ |    |____ |    |____ |");
    }
}
