package model.pojos;

public interface IDeck<T extends ICard> {
    public void shuffle();
    public T pop();
    public T peek();
    public void push(T c);
    public void reset();
    public boolean isEmpty();
    public T play(int index);
}
