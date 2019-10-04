package model;

public interface IDeck<T extends ICard> {
    public void shuffle();
    public T pop();
    public void push(T c);
    public void reset();
}
