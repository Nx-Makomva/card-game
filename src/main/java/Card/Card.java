package Card;

import java.util.Arrays;
import java.util.List;

public class Card {

    private String suit;
    private String symbol;
    private int value;
    private String visual;

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

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getVisual() {
        return visual;
    }

    public static List<String> getAllSuits(){
        return Arrays.asList("Spades", "Clubs", "Hearts", "Diamonds");
    }

    public static List<String> getAllSymbols(){
        return Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    }

    public boolean isKing() {
        return this.symbol.equals("K");
    }

    @Override
    public String toString() {
        return visual;
    }
}
