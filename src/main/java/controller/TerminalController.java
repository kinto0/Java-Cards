package controller;

import com.google.common.base.Preconditions;
import model.IGame;
import model.IGameAction;
import model.IModelEventListener;
import view.IView;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Since it is a terminal game, this controller can handle input and output, meaning a view is unnecessary.
 */
public class TerminalController implements IController, IModelEventListener {
    private final IView view;
    private final IGame game;
    private final Deque<IGameAction> actions;
    private boolean blocked;

    /**
     * Default constructor. Takes in a readable and an appendable for input and output.
     *  @param view view of the game
     *  @param game model of the game
     */
    public TerminalController(IView view, IGame game) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(game);
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
    public void addAction(IGameAction action) {
        actions.add(action);
        if (!blocked) {
            executeActions();
        }
    }

    private void executeActions() {
        while (!actions.isEmpty()) {
            IGameAction current = actions.pop();
            view.display(current.instructions());
            // TODO: wait on action to complete
        }
        this.blocked = false;
    }
}
