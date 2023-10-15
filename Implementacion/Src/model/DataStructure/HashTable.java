package model.DataStructure;

import model.DataStructure.DataStructureInterfaces.IHashTable;
import model.DataStructure.Nodes.HashNode;


import java.util.ArrayList;
import java.util.Collections;

public class HashTable<K,V> implements IHashTable<K,V> {
    private ArrayList<HashNode<K,V>> table;

    // The `public HashTable()` constructor is initializing the `table` variable of the `HashTable`
    // class. It creates a new `ArrayList` with an initial capacity of 8 and fills it with `null`
    // values using the `Collections.nCopies` method. This creates an empty hash table with 8 slots.
    public HashTable() {
        this.table = new ArrayList<>(Collections.nCopies(8, null));
    }

    /**
     * The function calculates the hash value for a given key using the multiplication method.
     *
     * @param key The parameter "key" is of type K, which means it can be any type that extends or
     * implements the class or interface K.
     * @return The method is returning an integer value.
     */
    public int hash(K key) {

        double frac = (Math.sqrt(5) -1)/2;

        double pruba = Math.abs(key.hashCode());

        int key1 = (int) Math.floor(table.size() *  (( (Math.abs(key.hashCode())) * (Math.sqrt(5) -1)/2) %1));
        return key1;
    }


    /**
     * @param key
     * @param value
     */
    @Override
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula.");
        }

        int index = hash(key);
        HashNode<K, V> nodeToAdd = new HashNode<>(key, value);

        if (table.get(index) == null) {
            table.set(index, nodeToAdd);
        } else {
            HashNode<K, V> current = table.get(index);
            nodeToAdd.setNext(current);
            table.set(index, nodeToAdd);
        }
    }

    /**
     * The search function in Java returns the value associated with a given key in a hash table.
     *
     * @param key The key parameter is of type K, which represents the type of the key used for
     * searching in the hash table.
     * @return The method is returning a value of type V, which is the value associated with the given
     * key in the hash table.
     */
    @Override
    public V search(K key) {
        int index = hash(key);
        return search(table.get(index), key);
    }

    /**
     * The search function recursively searches for a key in a linked list of HashNodes and returns the
     * corresponding value.
     *
     * @param node The `node` parameter is the current node being checked in the search process. It
     * represents a node in a hash table or hash map data structure.
     * @param key The "key" parameter is the key of the element we are searching for in the hash table.
     * @return The method is returning the value associated with the given key in the hash table.
     */
    private V search(HashNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return search(node.getNext(), key);
    }

    /**
     * The delete function in Java removes an element with a given key from a hash table.
     *
     * @param key The key parameter represents the key of the element that needs to be deleted from the
     * data structure.
     */
    @Override
    public void delete(K key) {
        int index = hash(key);
        table.set(index, delete(table.get(index), key));
    }

    /**
     * The function deletes a node with a specific key from a linked list.
     *
     * @param node The current node being checked for deletion.
     * @param key The key is the value that we want to delete from the hash table.
     * @return The method is returning the updated node after deleting the node with the specified key.
     */
    private HashNode<K, V> delete(HashNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (node.getKey().equals(key)) {
            // Encontramos la clave, la eliminamos
            return node.getNext();
        }

        node.setNext(delete(node.getNext(), key));
        return node;
    }

    /**
     * The function "print" returns a null value.
     *
     * @return The method is returning null.
     */
    @Override
    public String print() {
        return null;
    }

    /**
     * The function returns the ArrayList of HashNodes.
     *
     * @return The method is returning an ArrayList of HashNode objects.
     */
    public ArrayList<HashNode<K, V>> getTable() {
        return table;
    }

    /**
     * The function sets the table of the HashNode objects in the class.
     *
     * @param table The parameter "table" is an ArrayList of HashNode objects.
     */
    public void setTable(ArrayList<HashNode<K, V>> table) {
        this.table = table;
    }

}
