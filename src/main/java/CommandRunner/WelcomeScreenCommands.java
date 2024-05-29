package CommandRunner;

import BlackJack.BlackJackMain;
import PapazKimde.PapazKimde;

public class WelcomeScreenCommands extends CommandRunner {

    private static final String[] WELCOME_SCREEN_COMMANDS = {
            "Play Black Jack",
            "Play Papaz Kimde", // allow them to go back to game selection
            "Quit"
    };

    public WelcomeScreenCommands() {
        super(WELCOME_SCREEN_COMMANDS, "Introduction");
    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\nBetter to quit whilst you're ahead! See you next time");
            return;
        }

        System.out.println("You've chosen to " + WELCOME_SCREEN_COMMANDS[userSelection - 1]);
        switch(userSelection){
            case 1:
                // Play Game 1
                BlackJackMain.startGame();
                BlackJackMain.setGameOver(false);
                break;
            case 2:
                // Play Game 2
                PapazKimde whoHasTheKing = new PapazKimde();
                whoHasTheKing.playPapazKimde();
                break;
        }
    }
}
