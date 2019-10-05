package model;

import model.actions.GameOverAction;
import model.actions.IActionListener;
import model.actions.KeyboardAction;
import model.pojos.EmptyCardDeck;
import model.pojos.IDeck;
import model.pojos.StandardCard;
import model.pojos.StandardCardDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * Game of presidents.
 */
public class President implements IGame {

    private IModelEventListener<String> listener;
    private final IDeck<StandardCard> deck;
    private final IDeck<StandardCard> discards;
    private final List<IDeck<StandardCard>> hands;

    President() {
        this.deck = new StandardCardDeck();
        this.discards = new EmptyCardDeck();
        this.hands = new ArrayList<>();
    }

    @Override
    public void setupListener(IModelEventListener l) {
        this.listener = l;
    }

    @Override
    public void start() {
        listener.display("Welcome to President! In this game, each player competes with eachother to get rid of their cards the fastest! You may only play cards higher than the current card on the table. Playing two cards in a row skips the next person. If no one can play against someone's card, they start the next hand. ");
        listener.addAction(new KeyboardAction(new IActionListener<String>() {
            @Override
            public void callback(String input) {
                int players;
                try {
                    players = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    listener.display("Please enter a number greater than 1");
                    start();
                    return;
                }

                listener.display( players + " players selected");

                deck.shuffle();
                for (int c = 0; c < players; c++) {
                    hands.add(new EmptyCardDeck());
                }

                // deal all the cards
                for (int c = 0; !deck.isEmpty(); c++) {
                    hands.get(c % players).push(deck.pop());
                }

                initTurn(0, -1);
            }
        }, "How many players are playing today? Please type a number"));
    }

    /**
     * Initializes a turn. Recurs until someone wins.
     * @param player player number to go. Must be <= total players.
     * @param last last player to successfully play a card
     */
    private void initTurn(int player, int last) {
        // if we have gone in a full circle, empty discards.
        if (last == player) {
            while (!discards.isEmpty()) {
                discards.pop();
            }
        }
        // if someone has won, congrats!
        for (IDeck d : hands) {
            if (d.isEmpty()) {
                listener.addAction(new GameOverAction());
                return;
            }
        }
        listener.addAction(new KeyboardAction(new IActionListener<String>() {
            @Override
            public void callback(String input) {
                try {
                    int c = Integer.parseInt(input);
                    StandardCard card = hands.get(player).play(c);
                    switch (checkMove(card)) {
                        // Invalid move. Try again.
                        case -1:
                            initTurn(player, last);
                        // Valid move.
                        case 0:
                            discards.push(card);
                            initTurn((player + 1) % (hands.size() - 1), player);
                        // Skip move.
                        case 1:
                            discards.push(card);
                            initTurn((player + 2) % (hands.size() - 1), player);
                    }
                } catch (NumberFormatException e) {
                    switch(input) {
                        case "v":
                            listener.display(hands.get(player).toString());
                            initTurn(player, last);
                            return;
                        case "l":
                            listener.display(discards.peek().toString());
                            initTurn(player, last);
                            return;
                        case "s":
                            initTurn((player + 1) % (hands.size() - 1), last);
                        default:
                            initTurn(player, last);
                    }
                } catch (Exception e) {
                    initTurn(player, last);
                }
            }
        }, "Player " + player + "'s turn! Press v to view your hand, press l to see the last played card, press s to skip your turn, or type the card number to play that card. "));    }

    /**
     * Checks whether a move is valid.
     * @param card card to play
     * @return 0 for valid move, 1 for valid move + skip, -1 for invalid move
     */
    private int checkMove(StandardCard card) {
        StandardCard previous = discards.peek();
        if (card.getValue() == previous.getValue()) {
            return 1;
        }
        if (card.getValue() < previous.getValue()) {
            return -1;
        }

        return 0;
    }
}
