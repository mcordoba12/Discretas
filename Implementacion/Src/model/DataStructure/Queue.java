package Model.DataStructure;
import Model.DataStructure.DataStructureInterfaces.IQueue;
import Model.DataStructure.Nodes.QueueNode;

public class Queue<T> implements IQueue<T> {

    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    // The `add` method in the `Queue` class is used to add an element to the queue.
    public void add(T element) {
        QueueNode<T> nodeToAdd = new QueueNode<T>(element);
        if (front == null) {
            front = nodeToAdd;
            rear = nodeToAdd;
        } else {
            rear.setNext(nodeToAdd);
            rear = nodeToAdd;
        }
        size++;
    }

    /**
     * @return
     */
    @Override
    public T poll() {
        if (front == null) {
            return null;
        }
        T element = front.getElement();
        front = front.getNext();
        size--;
        return element;
    }

    /**
     * The function checks if the front of a queue is null, indicating that the queue is empty.
     *
     * @return The method is returning a boolean value, which indicates whether the front of the data
     * structure is null or not. If the front is null, it means the data structure is empty, so the
     * method will return true. Otherwise, it will return false.
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * The function returns the size of a data structure.
     *
     * @return The size of the object.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * The function returns the element at the front of a queue, or null if the queue is empty.
     *
     * @return The method is returning the element at the front of the queue.
     */
    @Override
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.getElement();
    }

    /**
     * The clear() function sets the front and rear pointers to null and the size to 0, effectively
     * clearing all elements from the data structure.
     */
    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * @param element
     */
    public void delete(T element) {
        QueueNode<T> current = front;
        QueueNode<T> previous = null;
        while (current != null) {
            if (current.getElement().equals(element)) {
                if (previous == null) {
                    front = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }



}