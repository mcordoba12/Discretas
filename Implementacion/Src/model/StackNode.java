package Model;
public class StackNode<T> {
    private T element;
    private StackNode<T> next;
    public StackNode(T element) {
        this.element = element;

    }

    public T getElement() {
        return element;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
