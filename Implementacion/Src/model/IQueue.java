package Implementacion.src.Model;


public interface IQueue<E> {
    void add(E element);
    E poll();
    boolean isEmpty();
    int size();
    E peek();
    void clear();
    

 
}

