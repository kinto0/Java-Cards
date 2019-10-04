package controller;

import model.IGame;

/**
 * Interface for a game controller. Accepts input and acts as the interface between view to model.
 */
public interface IController {

    /**
     * Starts the game.
     */
    void play();
}
