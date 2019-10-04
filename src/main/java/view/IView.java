package view;

import model.IModelEventListener;

/**
 * Interface for a {@link model.IGame} view. Will be fleshed out more if non-terminal views are created.
 */
public interface IView {

    /**
     * Display the inputted text.
     * @param text text to be displayed
     */
    void display(String text);

    /**
     * Sets up the listener to listen for player input.
     * @param l listener
     */
    void setupListener(IModelEventListener l);
}
