package model.pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A standard 52 card deck.
 */
public class StandardCardDeck implements IDeck<StandardCard> {
    private List<StandardCard> cards;

    /**
     * Default constructor. Creates an unshuffled deck.
     */
    public StandardCardDeck() {
        cards = new ArrayList<>();
        init();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public StandardCard pop() {
        if (cards.isEmpty()) {
            return new StandardCard(0, "Empty", StandardSuit.Diamonds);
        }
        StandardCard card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }

    @Override
    public StandardCard peek() {
        if (cards.isEmpty()) {
            return new StandardCard(0, "Empty", StandardSuit.Diamonds);
        }
        return cards.get(cards.size() - 1);
    }

    @Override
    public void push(StandardCard c) {
        cards.add(c);
    }

    @Override
    public void reset() {
        init();
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public StandardCard play(int index) {
        if (index >= cards.size()) {
            throw new IllegalArgumentException("Not that many cards");
        }

        return cards.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(i).append(": ").append(cards.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    protected void init() {
        for (int i = 1; i <= 10; i++) {
            for (int c = 0; c < 3; c++) {
                cards.add(new StandardCard(i, String.valueOf(i), StandardSuit.fromValue(c)));
            }
        }

        for (int c = 0; c < 3; c++) {
            cards.add(new StandardCard(11, "Jack", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(12, "Queen", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(13, "King", StandardSuit.fromValue(c)));
            cards.add(new StandardCard(14, "Ace", StandardSuit.fromValue(c)));
        }

    }
}
