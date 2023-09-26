package model;

public class PriorityQueueNode<T> {
    private T element;
    private int priority;
    private PriorityQueueNode<T> next;
    public PriorityQueueNode(T element, int priority) {
        this.element = element;
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public PriorityQueueNode<T> getNext() {
        return next;
    }

    public void setNext(PriorityQueueNode<T> next) {
        this.next = next;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

}
