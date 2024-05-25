package BlackJack.Commands;

import Card.Card;
import CommandRunner.CommandRunner;

import java.util.List;

public class ChooseCardCommandRunner extends CommandRunner {
    private boolean userPickUpCard = false;
    private int userSelection;
    private String[] chooseCardCommands;

    public ChooseCardCommandRunner(String[] chooseCardCommands, String name) {
        super(chooseCardCommands, "Picking a card");
        this.chooseCardCommands = chooseCardCommands;
    }

    public void setChooseCardCommands(String[] newCommands) {
        this.chooseCardCommands = newCommands;
        this.commands = newCommands;
    }

    public List<String> resetCommands(List<String> cardStrings, List<Card> playableCards) {
        cardStrings.clear();
        for (Card card : playableCards) {
            cardStrings.add(card.toString());
        }
        cardStrings.add("Pick up a card");

        return cardStrings;
    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\n Picking up from the Deck...\n");
            this.userPickUpCard = true;
            // figure out how to have command runner pass this info back
        } else {
            this.userSelection = userSelection;
        }
    }

    public boolean isPickingACard() {
        return userPickUpCard;
    }

    public int getUserSelection() {
        return userSelection;
    }


}

