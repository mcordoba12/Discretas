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

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.getElement();
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

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