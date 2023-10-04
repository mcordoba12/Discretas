package Model.DataStructure.DataStructureInterfaces;

/** The code is defining an interface called `IStack` which represents a stack data structure. The
*interface has several methods that can be implemented by classes that implement this interface.
*/
 public interface IStack <T> {
    public void push(T element);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
    public String print();

}
