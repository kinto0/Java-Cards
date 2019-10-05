package view;

import model.IModelEventListener;

import java.io.IOException;
import java.util.Scanner;

/**
 * View for playing the game in a terminal window.
 */
public class ConsoleView implements IView {

    private final Readable in;
    private final Appendable out;
    private IModelEventListener listener;

    public ConsoleView(Readable input, Appendable output)
    {
        this.in = input;
        this.out = output;
    }

    @Override
    public void display(String text) {
        try {
            out.append(text).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setupListener(IModelEventListener l) {
        this.listener = l;
    }

    @Override
    public String listen() {
        Scanner sc = new Scanner(in);

        while(!sc.hasNext()) {}

        return sc.next();
    }
}
