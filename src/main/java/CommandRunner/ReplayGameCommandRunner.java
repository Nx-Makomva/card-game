package CommandRunner;

import BlackJack.BlackJackMain;
import PapazKimde.PapazKimde;

public class ReplayGameCommandRunner extends CommandRunner {

    private static final String[] PLAY_AGAIN_COMMANDS = {
            "Yes, go back to main menu",
            "Quit"
    };

    public ReplayGameCommandRunner() {
        super(PLAY_AGAIN_COMMANDS, "Playing Again");
    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\nThanks for playing, see you next time!");
            return;
        } else {
            System.out.println("You've chosen to " + PLAY_AGAIN_COMMANDS[userSelection - 1]);
            WelcomeScreenCommands replay = new WelcomeScreenCommands();
            replay.runCommands();
        }
    }
}
