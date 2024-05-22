public class Card {

    private static String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
    private static String[] symbol = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    Card (String[] suit, String[] symbol, int[] value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public static String[] getSuit() {
        return suit;
    }

    public void setSuit(String[] suit) {
        this.suit = suit;
    }

    public static String[] getSymbol() {
        return symbol;
    }

    public void setSymbol(String[] symbol) {
        this.symbol = symbol;
    }

    public static int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
}
