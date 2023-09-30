package Implementacion.src.Model;

public class QueueNode<T> {
    private T element;
    private QueueNode<T> next;

    public QueueNode(T element) {
        this.element = element;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

}
