package controller;

import com.google.common.base.Preconditions;
import model.IGame;
import model.IActionListener;
import view.IView;

import java.util.Scanner;

/**
 * Since it is a terminal game, this controller can handle input and output, meaning a view is unnecessary.
 */
public class TerminalController implements IController, IActionListener {
    private final IView view;
    private final IGame game;

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

        view.setupListener(this);
        game.setupListener(this);
    }

    @Override
    public void play(IGame model) {
        game.start();
    }

    @Override
    public void display(String instructions) {
        view.display(instructions);
    }
}
