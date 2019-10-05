package model.actions;

public class KeyboardAction implements IGameAction<String> {

    private final IActionListener<String> l;
    private final String instructions;

    public KeyboardAction(IActionListener<String> l, String instructions) {
        this.l = l;
        this.instructions = instructions;
    }

    @Override
    public String instructions() {
        return instructions;
    }

    @Override
    public void complete(String command) {
        l.callback(command);
    }
}
