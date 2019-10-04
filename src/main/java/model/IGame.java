package model;

/**
 * Interface for a game. A game should be able to start, end ...
 */
public interface IGame {
    void setupListener(IModelEventListener l);
    void start();
}
