<<<<<<< HEAD:Implementacion/Src/model/StackNode.java
package Model;
=======
package Model.DataStructure.Nodes;

>>>>>>> 7e7908d3045be2a47d9654ac9acc6a241ab92b35:Implementacion/Src/model/DataStructure/Nodes/StackNode.java
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
