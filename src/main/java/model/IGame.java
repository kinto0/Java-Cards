package model;

/**
 * Interface for a game. A game should be able to start, end ...
 */
public interface IGame {
    /**
     * Sets up a listener for the game.
     * @param l listener
     */
    void setupListener(IModelEventListener l);

    /**
     * Starts the game.
     */
    void start();
}
