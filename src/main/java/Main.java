import BlackJack.BlackJackMain;
import Deck.Deck;
import PapazKimde.PapazKimde;

public class Main {

    public static void main(String[] args) {
        PapazKimde whoHasTheKing = new PapazKimde();
        whoHasTheKing.playPapazKimde();
//        Deck deck = new Deck();
//        deck.printDeck();
        BlackJackMain.startGame();
    }
}
