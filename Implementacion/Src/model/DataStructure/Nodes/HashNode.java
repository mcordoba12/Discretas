package Model.DataStructure.Nodes;

public class HashNode <K,V>{
    private HashNode<K,V> next;
    private K key;
    private V value;

    /** The `public HashNode(K key, V value)` constructor is initializing a new instance of the
    * `HashNode` class with the provided key and value. It sets the `next` reference to `null`, and
    * assigns the provided key and value to the respective instance variables.
    */
    public HashNode(K key, V value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    /**
     * The function returns the next node in a hash table.
     *
     * @return The method is returning the next HashNode in the linked list.
     */
    public HashNode<K,V> getNext() {
        return next;
    }

    /**
     * The function sets the next node in a linked list structure.
     *
     * @param next The "next" parameter is of type HashNode<K,V>, which represents the next node in a
     * linked list.
     */
    public void setNext(HashNode<K,V> next) {
        this.next = next;
    }

    /**
     * The function returns the key value.
     *
     * @return The method is returning the value of the variable "key".
     */
    public K getKey() {
        return key;
    }

    /**
     * The function sets the value of the "key" variable.
     *
     * @param key The "key" parameter is of type K, which means it can be any type specified by the
     * user when calling the method.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * The function returns the value stored in a variable.
     *
     * @return The method is returning the value of type V.
     */
    public V getValue() {
        return value;
    }

    /**
     * The function sets the value of a variable.
     *
     * @param value The parameter "value" is of type V, which means it can be any type of object.
     */
    public void setValue(V value) {
        this.value = value;
    }

}
