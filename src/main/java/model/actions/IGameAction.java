package model.actions;

/**
 * An action that the player can take.
 */
public interface IGameAction<R> {
    /**
     * Instructions for the action to be printed each time we wait for user's input. 
     * @return string representation of player's instructions 
     */
    public String instructions();

    /**
     * Callback for when action is completed. 
     * @param result players input
     */
    public void complete(R result);
}
