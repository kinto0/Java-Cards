package controller;

import model.IGame;
import model.actions.IGameAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import view.IView;

import static org.junit.Assert.*;

/**
 * Tests for {@link TerminalController} class.
 */
@RunWith(MockitoJUnitRunner.class)
public class TerminalControllerTest {

    @Mock
    private IView view;
    @Mock
    private IGame game;

    @Mock
    private IGameAction action;

    @Test
    public void testAdd1Action() {
        IController terminalController = new TerminalController(view, game);

        terminalController.addAction(action);

        Mockito.verify(this.view, Mockito.times(1)).listen();
    }

    @Test
    public void testAdd3Actions() {
        IController terminalController = new TerminalController(view, game);

        terminalController.addAction(action);
        terminalController.addAction(action);
        terminalController.addAction(action);

        Mockito.verify(this.view, Mockito.times(3)).listen();
    }

}