package Model.DataStructure.Nodes;

public class StackNode<T> {
    private T element;
    private StackNode<T> next;
    public StackNode(T element) {
        this.element = element;

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
     * The function returns the next node in a stack.
     *
     * @return The method is returning a StackNode object.
     */
    public StackNode<T> getNext() {
        return next;
    }

    /**
     * The function sets the next node in a stack.
     *
     * @param next The "next" parameter is of type StackNode<T>, which represents the next node in the
     * stack.
     */
    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    /**
     * The function sets the value of the "element" variable.
     *
     * @param element The parameter "element" is of type T, which means it can be any type. It is used
     * to set the value of the instance variable "element" in the current object.
     */
    public void setElement(T element) {
        this.element = element;
    }
}
