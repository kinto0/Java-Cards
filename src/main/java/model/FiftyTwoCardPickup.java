package model;

public class FiftyTwoCardPickup implements IGame {

    private IActionListener listener;
    private final IDeck deck;

    public FiftyTwoCardPickup(IActionListener l) {
        this.deck = new StandardCardDeck();
    }

    @Override
    public void setupListener(IActionListener l) {
        this.listener = l;
    }

    @Override
    public void start() {
        deck.shuffle();
        listener.display("All the cards have hit the floor! Please pick them up by typing 'p.' ");
    }
}
