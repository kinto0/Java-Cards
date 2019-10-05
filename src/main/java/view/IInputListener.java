package view;

/**
 * Input listener for telling the view to do things.
 */
public interface IInputListener {
    /**
     * Asks the view for input.
     * @return the input from view as a string
     */
    String listen();
}
