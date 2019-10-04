package model;

/**
 * Listens to actions from model/view to controller.
 */
public interface IModelEventListener {
    void display(String instructions);
    void addAction(IGameAction action);
}
