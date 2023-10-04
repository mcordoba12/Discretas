package Model.DataStructure.DataStructureInterfaces;

/**The code is defining an interface called `IQueue` with a generic type `E`.
*/
 public interface IQueue<E> {
    void add(E element);
    E poll();
    boolean isEmpty();
    int size();
    E peek();
    void clear();



}
