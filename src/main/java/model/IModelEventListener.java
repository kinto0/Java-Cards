package model;

import model.actions.IGameAction;

/**
 * Listens to actions from model/view to controller.
 */
public interface IModelEventListener<T> {
    /**
     * Text to display to view.
     * @param instructions instructions as string
     */
    void display(String instructions);

    /**
     * Action for a player to take.
     * @param action action
     */
    void addAction(IGameAction<T> action);
}
