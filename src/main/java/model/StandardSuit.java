package model;

public enum StandardSuit {
    Hearts("Hearts"),
    Spades("Spades"),
    Clubs("Clubs"),
    Diamonds("Diamonds");

    private String suit;

    StandardSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.suit;
    }

    public static StandardSuit fromValue(int value) {
        switch (value) {
            case 0:
                return StandardSuit.Hearts;
            case 1:
                return StandardSuit.Spades;
            case 2:
                return StandardSuit.Clubs;
            default:
                return StandardSuit.Diamonds;
        }
    }
}