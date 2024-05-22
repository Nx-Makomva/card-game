import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deckOfCards = new ArrayList<>();

    public Deck(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

//    Deck() {
//        String[] suits = Card.getSuit();
//        String[] symbols = Card.getSymbol();
//        int[] values = Card.getValue();
//
//        for (String suit : suits) {
//            for (String symbol : symbols) {
//                for (int value : values){
//                deckOfCards.add(new Card(suit, symbol, value))
//            }
//        }
//    }
//
////    public Card dealCard(List<Card> deckOfCards) {
////        return deckOfCards.get(0);
////    }
//
//    public void sortDeck() {
//        deckOfCards = deckOfCards.stream()
//                .sorted((a,b) -> a.value - b.value);
//    }
//
}
