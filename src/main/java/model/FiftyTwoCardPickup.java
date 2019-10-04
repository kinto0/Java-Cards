package model;

public class FiftyTwoCardPickup implements IGame {

    private IModelEventListener listener;
    private final IDeck deck;

    public FiftyTwoCardPickup(IModelEventListener l) {
        this.deck = new StandardCardDeck();
    }

    @Override
    public void setupListener(IModelEventListener l) {
        this.listener = l;
    }

    @Override
    public void start() {
        deck.shuffle();
        listener.display("All the cards have hit the floor!");
        listener.addAction(new PickUpCardAction(new IActionListener() {
            @Override
            public void complete(String card) {
                listener.display("You picked up " + card + "!");
            }
        }));
    }
}
