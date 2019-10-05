package model;

import model.actions.GameOverAction;
import model.actions.IActionListener;
import model.actions.KeyboardAction;
import model.pojos.IDeck;
import model.pojos.StandardCardDeck;

/**
 * 52 card pickup. The simplest of games.
 */
public class FiftyTwoCardPickup implements IGame {

    private IModelEventListener<String> listener;
    private final IDeck deck;

    FiftyTwoCardPickup() {
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

        for (int i = 0; i < 52; i++){
            listener.addAction(new KeyboardAction(new IActionListener<String>() {
                @Override
                public void callback(String input) {
                    listener.display("You picked up " + deck.pop().toString() + "!");
                }
            }, "Press any key to pick up a card!"));
        }

        listener.addAction(new GameOverAction());
    }
}
