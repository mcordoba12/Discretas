package model;

public class HashTable <K,V> implements IHashTable<K,V> {
    private HashNode<K,V>[] table;
    private int size;

    public HashTable (int size) {
        this.size = size;
        this.table = new HashNode[size];
    }

    public int hash(K key) {
        int index = key.hashCode() % size;
        return index;
    }


    @Override
    public void insert(K key, V value) {
        int index = hash(key);
        HashNode<K,V> nodeToAdd = new HashNode<K,V>(key, value);
        if (table[index] == null) {
            table[index] = nodeToAdd;
        } else {
            nodeToAdd.setNext(table[index]);
            table[index] = nodeToAdd;
        }
    }



}
