package CommandRunner;

import java.util.Scanner;

public abstract class CommandRunner {


public static final String QUIT = "quit";
private Scanner scanner = new Scanner(System.in);
private String name;
protected String[] commands;

public CommandRunner(String[] commands, String name) {
    this.commands = commands;
    this.name = name;
}

public void runCommands() {
    intro();

    printIndexedCommands();
    int userSelection = readUserInput(commands.length);

    handleUserSelection(userSelection);

    }


protected void intro() {
    printMessage(String.format("\n Please make a choice for %s\n", name));
}


protected abstract void handleUserSelection(int userSelection);

protected int readUserInput(int limit) {

        printMessage(String.format("Please enter a number between 1 and %d:", limit));

    while (true) {

        String input = scanner.nextLine();
        if (QUIT.equalsIgnoreCase(input.trim())) {
            return -1;
        }

        try {
            int userSelection = Integer.valueOf(input.trim());

            if (userSelection < 1 || userSelection > limit) {
                printMessage("Please enter a number between 1 and " + limit);
            } else {
                return userSelection;
            }

        } catch (Exception e) {
            printMessage("Please enter a number between 1 and " + limit);
        }
    }
}

protected void printIndexedCommands() {
    printIndexedCommands(commands);
}

protected void printIndexedCommands(String[] commands) {
    for (int i = 0; i < commands.length; i++) {
        printMessage((i + 1) + ": " + commands[i]);
    }
}

    protected void printMessage(String message) {
        System.out.println(message);
    }
}
