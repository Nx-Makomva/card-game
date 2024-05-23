package BlackJack.CommandRunner;

import BlackJack.BlackJackMain;


public class WelcomeScreenCommands extends CommandRunner {

    private static final String[] WELCOME_SCREEN_COMMANDS = {
            "Play Game",
            "Go back to 'Choose Game'", // allow them to go back to game selection
            "Quit"
    };

    public WelcomeScreenCommands() {
        super(WELCOME_SCREEN_COMMANDS, "Introduction");
    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\nBetter to quit whilst you're ahead! See you next time");
            BlackJackMain.setGameOver(true);
            return;
        }

        System.out.println("You've chosen to " + WELCOME_SCREEN_COMMANDS[userSelection - 1]);
        switch(userSelection){
            case 1:
                BlackJackMain.setGameOver(false);
                break;
            case 2:
//                GameLoader.chooseGame();
        }
    }
}
