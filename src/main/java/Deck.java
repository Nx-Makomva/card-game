import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deckOfCards = new ArrayList<>();

    public Deck(List<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    Deck() {
        List<String> suits = Card.getAllSuits();
        List<String> symbols = Card.getAllSymbols();
        int value = 0;

        for (String suit : suits) {
            for (String symbol : symbols) {
                value++;
                deckOfCards.add(new Card(suit, symbol, value));
            }
        }

//        public Card dealCard (List < Card > deckOfCards) {
//            return deckOfCards.get(0);
//        }
//
//        public void sortDeck () {
//            deckOfCards = deckOfCards.stream()
//                    .sorted((a, b) -> a.value - b.value);
//        }

    }
}
