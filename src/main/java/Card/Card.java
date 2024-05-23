package Card;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String suit;
    private String symbol;
    private int value ;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // method to return a list of suits that are valid for card objects
    // static because does not need to have a card object to be called/used
    public static List<String> getAllSuits(){
        return Arrays.asList("Spades", "Clubs", "Hearts", "Diamonds");
    }

    // method to return a list of symbols that are valid for card objects
    // static because does not need to have a card object to be called/used
    public static List<String> getAllSymbols(){
        return Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    }

    public boolean isKing() {
        return this.symbol.equals("K");
    }

    @Override
    public String toString() {
        return String.format(symbol + " of " + suit);
    }
}
