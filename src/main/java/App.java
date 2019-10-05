import controller.IController;
import controller.TerminalController;
import model.GameFactory;
import model.IGame;
import view.ConsoleView;
import view.IView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        String arg = "";
        if (args.length > 0) {
            arg = args[0];
        }

        IView view = new ConsoleView(new BufferedReader(new InputStreamReader(System.in)), System.out);
        IGame game = GameFactory.factoryGame(arg);
        IController controller = new TerminalController(view, game);

        game.setupListener(controller);
        view.setupListener(controller);
        controller.play();
    }
}
