package Model.DataStructure.DataStructureInterfaces;

/** The code is defining an interface called `IPriorityQueue` which represents a priority queue data
* structure.
*/
public interface IPriorityQueue<K extends Comparable,V> {
    K heapExtractMax ();
    K getmaX ();
    String increaseKey(int position, K key);
    void insert (K key,V value);

    int getHeapSize();

    void delete(V value);


}