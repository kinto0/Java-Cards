package view;

import model.IActionListener;

import java.io.IOException;

/**
 * View for playing the game in a terminal window.
 */
public class ConsoleView implements IView {

    private final Readable in;
    private final Appendable out;
    private IActionListener listener;

    public ConsoleView(Readable input, Appendable output)
    {
        this.in = input;
        this.out = output;
    }

    @Override
    public void display(String text) {
        try {
            out.append(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //todo: figure out player input

    @Override
    public void setupListener(IActionListener l) {
        this.listener = l;
    }
}
