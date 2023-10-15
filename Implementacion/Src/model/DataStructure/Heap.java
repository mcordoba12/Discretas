package model.DataStructure;
import java.util.ArrayList;

import model.DataStructure.DataStructureInterfaces.IPriorityQueue;
import model.DataStructure.Nodes.HeapNode;

public class Heap<K extends Comparable,V> implements IPriorityQueue<K,V> {

    private ArrayList<HeapNode<K,V>> list;

    private int heapSize;

    /**
     * The maxHeapify function is used to maintain the max heap property of a binary heap by
     * recursively swapping elements to ensure that the parent node is always greater than its
     * children.
     *
     * @param position The position parameter represents the index of the element in the heap that
     * needs to be max heapified.
     */
    public void maxHeapify(int position){
        int left  = getLeft(position);
        int right  = getRigth(position);
        int largest = position;

        if (left < heapSize){
            if (  list.get(left).getKey().compareTo(list.get(position).getKey()) > 0 )largest = left;
        }

        if (right < heapSize){
            if (  list.get(right).getKey().compareTo(list.get(largest).getKey()) > 0 ) largest = right;
        }

        if (largest != position){
            HeapNode temporal = list.get(position);
            list.set(position, list.get(largest));
            list.set(largest, temporal);
            maxHeapify(largest);
        }
    }

    /**
     * The function "buildHeap" builds a max heap from a given list of elements.
     */
    public void buildHeap(){
        this.heapSize = list.size();
        for (int i = (list.size() /2) -1; i >=0 ; i--) {
            maxHeapify(i);
        }
    }

    /**
     * The function performs a heap sort on a list by repeatedly swapping the root element with the
     * last element, reducing the heap size, and maintaining the max heap property.
     */
    public void heapSort(){
        buildHeap();
        for (int i = list.size()-1; i >= 1 ; i--) {
            HeapNode temporal = list.get(0);
            list.set(0,list.get(i));
            list.set(i, temporal);
            heapSize-=1;
            maxHeapify(0);
        }

    }

    /**
     * The function returns the index of the parent node given the index of a node in a binary tree.
     *
     * @param position The parameter "position" represents the index of a node in a binary tree.
     * @return The method is returning the position of the father node in a binary tree.
     */
    public int getFather(int position) {
        position+=1;
        if (position == 0) return 0;
        else return  position/2 -1;
    }

    /**
     * The function returns the left child position of a given position in a binary tree.
     *
     * @param position The parameter "position" is an integer value representing the current position.
     * @return The method is returning the left child position of the given position.
     */
    public int getLeft(int position) {
        position+=1;
        return position*2 - 1 ;
    }

    /**
     * The function takes a position as input, increments it by 1, and returns the result multiplied by
     * 2.
     *
     * @param position The parameter "position" is an integer representing a position.
     * @return The method is returning the result of multiplying the incremented position by 2.
     */
    public int getRigth(int position) {
        position+=1;
        return position*2;
    }

    //Priority Queue methods

    /**
     * The function `heapExtractMax` extracts the maximum element from a max heap and returns it.
     *
     * @return The method `heapExtractMax()` returns the maximum element (of type K) from the heap.
     */
    @Override
    public K heapExtractMax() {
        if (heapSize < 0 ) return null;
        K max = list.get(0).getKey();
        list.set(0, list.get(heapSize-1));
        heapSize --;
        maxHeapify(0);
        return max;
    }


    /**
     * The function returns the maximum key value from a list of objects.
     *
     * @return The method is returning the key of the first element in the list.
     */
    @Override
    public K getmaX() {
        return list.get(0).getKey();
    }

    /**
     * The function increases the key of a node in a heap and maintains the heap property by swapping
     * the node with its parent until the heap property is satisfied.
     *
     * @param position The position parameter represents the index of the element in the list that
     * needs to have its key increased.
     * @param key The key is the new value that you want to increase the priority to.
     * @return The method is returning a String. If the key is not greater than the current key at the
     * specified position, it returns "Not incrementing priority". Otherwise, it returns "Increment
     * done".
     */
    @Override
    public String increaseKey(int position, K key) {
        if (key.compareTo(list.get(position).getKey()) < 0) {
            return "Not incrementing priority";
        }
        list.get(position).setKey(key);

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0 ){

            HeapNode temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
        return "Increment done";
    }


    /**
     * The insert function adds a new node to a heap data structure and maintains the heap property by
     * swapping nodes if necessary.
     *
     * @param key The key parameter is the key of the element being inserted into the heap. It is used
     * to determine the position of the element in the heap based on its priority or value.
     * @param value The value is the value associated with the key that is being inserted into the
     * heap.
     */
    @Override
    public void insert(K key, V value) {
        heapSize ++;
        list.add(new HeapNode<>(key, value));


        int position = heapSize-1;

        while (position > 0 && list.get(getFather(position)).getKey().compareTo(list.get(position).getKey()) < 0 ){

            HeapNode temporal = list.get(getFather(position));
            list.set(getFather(position), list.get(position));
            list.set(position, temporal);
            position = getFather(position);
        }
    }

    // The `delete` method in the `Heap` class is used to remove an element from the heap based on its
    // value
    public void delete(V value){
        int position = searchByValue(value);
        if (position == -1) return;
        change(position, heapSize-1);
        heapSize--;
        if (list.size() > 0){
            maxHeapify(position);
        }
    }


    /**
     * The function searches for a specific value in a list and returns the index of the first
     * occurrence, or -1 if the value is not found.
     *
     * @param value The "value" parameter is the value that you want to search for in the list.
     * @return The method `searchByValue` returns an integer value. If the value is found in the list,
     * it returns the index of the element that contains the value. If the value is not found, it
     * returns -1.
     */
    public int searchByValue(V value){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue().equals(value)) return i;
        }
        return -1;
    }

    /**
     * The function "change" swaps the elements at two given positions in a list.
     *
     * @param position The position parameter represents the index of the first element that needs to
     * be swapped.
     * @param position2 The position of the second element in the list that you want to swap with the
     * element at position.
     */
    public void change(int position, int position2){
        HeapNode temporal = list.get(position);
        list.set(position, list.get(position2));
        list.set(position2, temporal);
    }

    // The `public Heap()` constructor initializes a new instance of the `Heap` class. It sets the
    // `list` variable to a new empty `ArrayList` and sets the `heapSize` variable to 0. This
    // constructor is used to create a new heap object with an empty list and no elements.
    public Heap() {
        list = new ArrayList<>();
        heapSize = 0;
    }
    //Getters and Setters

    public ArrayList<HeapNode<K, V>> getList() {
        return list;
    }

    public void setList(ArrayList<HeapNode<K, V>> list) {
        this.list = list;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}