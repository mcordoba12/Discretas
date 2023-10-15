package model.DataStructure.Nodes;


public class QueueNode<T> {
    private T element;
    private QueueNode<T> next;

    // The `public QueueNode(T element)` constructor is initializing a new instance of the `QueueNode`
    // class. It takes a parameter `element` of type `T` and assigns it to the `element` variable of
    // the `QueueNode` object. It also sets the `next` variable to `null`, indicating that this node
    // does not have a next node yet.
    public QueueNode(T element) {
        this.element = element;
        this.next = null;
    }

    /**
     * The getElement() function returns the element stored in the object.
     *
     * @return The method is returning an element of type T.
     */
    public T getElement() {
        return element;
    }

    /**
     * The function returns the next node in the queue.
     *
     * @return The method is returning a QueueNode object.
     */
    public QueueNode<T> getNext() {
        return next;
    }

    /**
     * The function sets the value of the "element" variable.
     *
     * @param element The parameter "element" is of type T, which means it can be any type specified
     * when the class or method is used.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * The function sets the next node in a queue.
     *
     * @param next The "next" parameter is of type QueueNode<T>, which represents the next node in the
     * queue.
     */
    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

}