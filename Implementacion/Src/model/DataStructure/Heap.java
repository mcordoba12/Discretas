package Model.DataStructure;
import java.util.ArrayList;

import Model.DataStructure.DataStructureInterfaces.IPriorityQueue;
import Model.DataStructure.Nodes.HeapNode;

public class Heap<K extends Comparable,V> implements IPriorityQueue<K,V> {

    private ArrayList<HeapNode<K,V>> list;

    private int heapSize;

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

    public void buildHeap(){
        this.heapSize = list.size();
        for (int i = (list.size() /2) -1; i >=0 ; i--) {
            maxHeapify(i);
        }
    }

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

    public int getFather(int position) {
        position+=1;
        if (position == 0) return 0;
        else return  position/2 -1;
    }

    public int getLeft(int position) {
        position+=1;
        return position*2 - 1 ;
    }

    public int getRigth(int position) {
        position+=1;
        return position*2;
    }

    //Priority Queue methods


    @Override
    public K heapExtractMax() {
        if (heapSize < 0 ) return null;
        K max = list.get(0).getKey();
        list.set(0, list.get(heapSize-1));
        heapSize --;
        maxHeapify(0);
        return max;
    }


    @Override
    public K getmaX() {
        return list.get(0).getKey();
    }

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

    public void delete(V value){
        int position = searchByValue(value);
        if (position == -1) return;
        change(position, heapSize-1);
        heapSize--;
        if (list.size() > 0){
            maxHeapify(position);
        }
    }

    public int searchByValue(V value){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue().equals(value)) return i;
        }
        return -1;
    }

    public void change(int position, int position2){
        HeapNode temporal = list.get(position);
        list.set(position, list.get(position2));
        list.set(position2, temporal);
    }

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