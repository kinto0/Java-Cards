package model;

public class PickUpCardAction implements IGameAction {

    private final IActionListener l;

    public PickUpCardAction(IActionListener l) {
        this.l = l;
    }

    @Override
    public String instructions() {
        return "Press p to pick up card. ";
    }

    @Override
    public void complete(String card) {
        // todo: add specific card here
        l.complete(card);
    }
}
