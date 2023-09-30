package Model;
import Model.DataStructureInterfaces.IStack;
public class Stack <T> implements IStack<T> {
    private StackNode<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        StackNode<T> nodeToAdd = new StackNode<T>(element);
        if (top == null) {
            top = nodeToAdd;
        } else {
            nodeToAdd.setNext(top);
            top = nodeToAdd;
        }
        size++;
    }

    @Override
    public T pop() {
        if (top == null) {
            return null;
        }
        T element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String print() {
        String msg = "";
        StackNode<T> aux = top;
        while (aux != null) {
            msg += aux.getElement() + "\n";
            aux = aux.getNext();
        }
        return msg;
    }



}
