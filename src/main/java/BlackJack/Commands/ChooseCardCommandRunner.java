package BlackJack.Commands;

import CommandRunner.CommandRunner;

public class ChooseCardCommandRunner extends CommandRunner {
    private boolean userPickUpCard = false;
    private int userSelection;

    public ChooseCardCommandRunner(String[] chooseCardCommands, String name) {
        super(chooseCardCommands, "Picking a card");

    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\n Picking up from the Deck...");
            this.userPickUpCard = true;
            System.out.println(userSelection);
            System.out.println(userPickUpCard);
             // figure out how to have command runner pass this info back
        } else {
            this.userSelection = userSelection;
        }

    }

    public boolean getUserSelection() {
        return userPickUpCard;
    }





}

