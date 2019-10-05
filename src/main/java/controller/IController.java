package controller;

import model.IGame;
import model.IModelEventListener;

/**
 * Interface for a game controller. Accepts input and acts as the interface between view to model.
 */
public interface IController<T> extends IModelEventListener<T> {

    /**
     * Starts the game.
     */
    void play();
}
