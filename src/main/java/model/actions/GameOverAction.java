package model.actions;

public class GameOverAction implements IGameAction<String> {
    @Override
    public String instructions() {
        return "Game over!";
    }

    @Override
    public void complete(String result) {}
}
