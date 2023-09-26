package model;

public class PriorityQueue <T> implements IPriorityQueue<T> {
    private PriorityQueueNode<T> first;
    private int size;

    public PriorityQueue() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T element, int priority) {
        PriorityQueueNode<T> nodeToAdd = new PriorityQueueNode<T>(element, priority);
        if (first == null) {
            first = nodeToAdd;
        } else {
            PriorityQueueNode<T> aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nodeToAdd);
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (first == null) {
            return null;
        }
        T element = first.getElement();
        first = first.getNext();
        size--;
        return element;
    }

    @Override
    public T peek() {
        if (first == null) {
            return null;
        }
        return first.getElement();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String print() {
        String msg = "";
        PriorityQueueNode<T> aux = first;
        while (aux != null) {
            msg += aux.getElement() + "\n";
            aux = aux.getNext();
        }
        return msg;
    }

    
}
