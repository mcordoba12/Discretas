package Model.DataStructure;

import Model.DataStructure.DataStructureInterfaces.IHashTable;
import Model.DataStructure.Nodes.HashNode;

import java.util.ArrayList;
import java.util.Collections;

public class HashTable<K,V> implements IHashTable<K,V> {
    private ArrayList<HashNode<K,V>> table;




    public HashTable() {
        this.table = new ArrayList<>(Collections.nCopies(8, null));
    }

    public int hash(K key) {



        double frac = (Math.sqrt(5) -1)/2;

        double pruba = Math.abs(key.hashCode());

        int key1 = (int) Math.floor(table.size() *  (( (Math.abs(key.hashCode())) * (Math.sqrt(5) -1)/2) %1));
        return key1;
    }


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


    @Override
    public V search(K key) {
        int index = hash(key);
        return search(table.get(index), key);
    }

    private V search(HashNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return search(node.getNext(), key);
    }

    @Override
    public void delete(K key) {
        int index = hash(key);
        table.set(index, delete(table.get(index), key));
    }

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
    @Override
    public String print() {
        return null;
    }

    public ArrayList<HashNode<K, V>> getTable() {
        return table;
    }

    public void setTable(ArrayList<HashNode<K, V>> table) {
        this.table = table;
    }

}
