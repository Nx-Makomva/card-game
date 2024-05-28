package BlackJack.Commands;

import BlackJack.PlayerBlackJack.PlayerBlackJack;
import Card.Card;
import CommandRunner.CommandRunner;

import java.util.List;

public class ChooseCardCommandRunner extends CommandRunner {

    private boolean userPickUpCard = false;
    private int userSelection;
    private String[] chooseCardCommands;

    public ChooseCardCommandRunner(String[] chooseCardCommands, String title, PlayerBlackJack currentPlayer) {
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

        this.userPickUpCard = false;
        return cardStrings;
    }

    @Override
    protected void handleUserSelection(int userSelection) {
        if (userSelection == this.commands.length) {
            printMessage("\n Picking up from the Deck...\n");
            this.userPickUpCard = true;
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

    @Override
    public void runCommands() {
        super.runCommands();
    }

}

