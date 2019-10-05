package model.actions;

/**
 * An action listener for the {@link model.actions.IGameAction}
 * @param <T>
 */
public interface IActionListener<T> {
    public void callback(T input);
}
