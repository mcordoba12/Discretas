package model;

public interface IPriorityQueue<T> {
    public void enqueue(T element, int priority);
    public T dequeue();
    public T peek();
    public boolean isEmpty();
    public int size();
    public String print();

}
