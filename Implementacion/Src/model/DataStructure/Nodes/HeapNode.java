package model.DataStructure.Nodes;

public class HeapNode<K extends Comparable, V> {
    private K key;
    private V value;

    /**
    *The `public HeapNode(K key, V value)` constructor is initializing a new instance of the
    * `HeapNode` class with the provided `key` and `value` parameters. It sets the `key` and `value`
    * fields of the `HeapNode` object to the values passed in as arguments.
    */
     public HeapNode(K key, V value) {
        this.key = key;
        this.value = value;
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
