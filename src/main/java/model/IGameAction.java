package model;

/**
 * An action that the player can take.
 */
public interface IGameAction {
    public String instructions();
    public void complete(String result);
}
