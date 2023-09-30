package Implementacion.src.Model;

public class hash<K,V> implements IHashTable<K,V> {
    private ArrayList<HashNode<K,V>> table;

    public HashTable(ArrayList<HashNode<K, V>> table) {
        this.table = table;
    }

    public int hash(K key) {
        return key.hashCode() % size;
    }


    @Override
    public void insert(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (table.get(index) == null) {
            table.set(index, newNode);
        } else {
            HashNode<K, V> currentNode = table.get(index);
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    @Override
    public V search(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = table.get(index);

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }

        return null; // Key not found
    }

    @Override
    public void delete(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = table.get(index);
        HashNode<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (prevNode == null) {
                    // The node to delete is the first node in the list
                    table.set(index, currentNode.getNext());
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                return; // Key found and deleted
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public String print() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < table.size(); i++) {
            stringBuilder.append("Bucket ").append(i).append(": ");
            HashNode<K, V> currentNode = table.get(i);
            while (currentNode != null) {
                stringBuilder.append("(").append(currentNode.getKey()).append(", ").append(currentNode.getValue()).append(") ");
                currentNode = currentNode.getNext();
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public ArrayList<HashNode<K, V>> getTable() {
        return table;
    }

    public void setTable(ArrayList<HashNode<K, V>> table) {
        this.table = table;
    }
}
