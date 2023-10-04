package Model.DataStructure;

import Model.DataStructure.DataStructureInterfaces.IStack;
import Model.DataStructure.Nodes.StackNode;

public class Stack <T> implements IStack<T> {
    private StackNode<T> top;
    private int size;

    // The `public Stack()` constructor is initializing the `top` variable to `null` and the `size`
    // variable to `0`. This means that when a new `Stack` object is created, it will have no elements
    // and its `top` will be pointing to `null`.
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * The push function adds a new element to the top of the stack.
     *
     *
     * 
     * @param element The element to be pushed onto the stack.
     */
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

    /**
     * The pop() function removes and returns the top element of a stack, updating the top pointer and
     * decreasing the size of the stack.
     *
     * @return The method is returning the element that was popped from the top of the stack.
     */
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

    /**
     * The function returns the element at the top of the stack without removing it.
     *
     * @return The method is returning the element at the top of the stack.
     */
    @Override
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getElement();
    }

    /**
     * The function checks if the top element of a stack is null, indicating that the stack is empty.
     *
     * @return The method is returning a boolean value, which indicates whether the stack is empty or
     * not.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
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
     * The function iterates through a stack and concatenates the elements into a string, separated by
     * newlines.
     *
     * @return The method is returning a string representation of the elements in the stack.
     */
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
