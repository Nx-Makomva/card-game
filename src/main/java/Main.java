public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
//        System.out.println(deck);
//        System.out.println("printed deck: ");
        deck.shuffleDeck();
        deck.printDeck();
        System.out.println(" reset deck \n\n");
        deck.resetDeck();
        deck.printDeck();
    }
}
