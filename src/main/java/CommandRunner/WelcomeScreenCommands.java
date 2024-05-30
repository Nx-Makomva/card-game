package CommandRunner;

import BlackJack.BlackJackMain;
import PapazKimde.PapazKimde;

public class WelcomeScreenCommands extends CommandRunner {

    private static final String[] WELCOME_SCREEN_COMMANDS = {
            "Play Black Jack",
            "Play Papaz Kimde",
            "Quit"
    };

    public WelcomeScreenCommands() {
        super(WELCOME_SCREEN_COMMANDS, "the Game Menu");
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
                BlackJackMain.setGameOver(false);
                BlackJackMain.startGame();
                break;
            case 2:
                PapazKimde whoHasTheKing = new PapazKimde();
                whoHasTheKing.playPapazKimde();
                break;
        }
    }
}
