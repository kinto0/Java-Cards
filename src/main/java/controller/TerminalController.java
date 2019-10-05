package controller;

import model.IGame;
import model.actions.IGameAction;
import view.IView;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This controller connects the model (game) and the view together.
 */
public class TerminalController implements IController<String> {
    private final IView view;
    private final IGame game;
    private final Deque<IGameAction<String>> actions;
    private boolean blocked;

    /**
     * Default constructor. Takes in a readable and an appendable for input and output.
     *  @param view view of the game
     *  @param game model of the game
     */
    public TerminalController(IView view, IGame game) {
        this.view = view;
        this.game = game;
        this.blocked = false;

        view.setupListener(this);
        game.setupListener(this);
        actions = new ArrayDeque<>();
    }

    @Override
    public void play() {
        game.start();
    }

    @Override
    public void display(String instructions) {
        view.display(instructions);
    }

    @Override
    public void addAction(IGameAction<String> action) {
        actions.add(action);
        if (!blocked) {
            executeActions();
        }
    }

    private void executeActions() {
        while (!actions.isEmpty()) {
            IGameAction<String> current = actions.pop();
            view.display(current.instructions());
            current.complete(view.listen());
        }
        this.blocked = false;
    }
}
