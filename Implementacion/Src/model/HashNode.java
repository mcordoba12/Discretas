package Model;

public class HashNode <K,V>{
    private HashNode<K,V> next;
    private K key;
    private V value;

    public HashNode(K key, V value) {
        this.next = null;
        this.key = key;
        this.value = value;
    }

    public HashNode<K,V> getNext() {
        return next;
    }

    public void setNext(HashNode<K,V> next) {
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
