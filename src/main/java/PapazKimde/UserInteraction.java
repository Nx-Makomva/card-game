package PapazKimde;

import java.util.Random;
import java.util.Scanner;

public class UserInteraction {
    Scanner newScannerObject = new Scanner(System.in);

    public int howManyPlayers() {
        System.out.println("pick number of players: 2-4");

        while (true) {
            int numberInput = newScannerObject.nextInt();
            switch (numberInput) {
                case 2:
                case 3:
                case 4:
                    return numberInput;
                default:
                    System.out.println("Invalid choice. Please pick between 2 and 4.");
            }
        }
    }

    public String getUserInput() {
        return newScannerObject.next();
    }

    public boolean isHumanPlayer() {
        while (true) {
            String input = newScannerObject.next().toLowerCase();
            switch (input) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
            }
        }
    }
}
