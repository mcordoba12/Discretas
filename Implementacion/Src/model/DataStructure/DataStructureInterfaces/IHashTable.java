package Model.DataStructure.DataStructureInterfaces;

/** The code is defining an interface called `IHashTable` which represents a hash table data structure.
*The interface has four methods:
 */
public interface IHashTable <K,V> {
    public void insert(K key, V value);
    public V search(K key);
    public void delete(K key);
    public String print();

}
