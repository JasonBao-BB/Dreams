package Heap;

public class MaxHeap {
    private int capacity;
    private int size;
    private int[] data;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        data = new int[capacity];
    }
    public MaxHeap(){
        this.capacity = 10;
        this.size = 0;
        data = new int[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean offer(int key){
        this.data[size++] = key;
        siftUp();
        return true;
    }
    public int poll(){
        int t = data[0];
        data[0] = data[size-1];
        data[size-1] = 0;
        size--;
        siftDown();
        return t;
    }
    public int peek(){
        return data[0];
    }
    public int size(){
        return size;
    }
    private void heapify(int[] data) {
        for(int i=getParentIndex(size-1); i>=0; i--){
            siftDownHeapify(i);
        }
    }
    private int getParentIndex(int index){
        return (index-1)/2;
    }
    private int getLeftChildIndex(int index){
        return index*2+1;
    }
    private int getRightChildIndex(int index){
        return index*2+2;
    }

    private int leftChild(int index){
        return this.data[getLeftChildIndex(index)];
    }

    private int rightChild(int index){
        return this.data[getRightChildIndex(index)];
    }

    private int parent(int index){
        return this.data[getParentIndex(index)];
    }

    private void swap(int[] data, int i, int j){
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void siftUp(){
        int index = size-1;
        while (getParentIndex(index) >= 0 && parent(index) < data[index]){
            swap(data, getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void siftDown(){
        int index = 0;
        while (getLeftChildIndex(index) < size){
            int biggerChildIndex = getLeftChildIndex(index);
            if(getRightChildIndex(index) < size && rightChild(index) > leftChild(index)){
                biggerChildIndex = getRightChildIndex(index);
            }
            if(data[index] < data[biggerChildIndex]){
                swap(data, index, biggerChildIndex);
            } else {
                break;
            }
            index = biggerChildIndex;
        }
    }

    private void siftDownHeapify(int index){
        while(getLeftChildIndex(index) < size){
            int biggerChildIndex = getLeftChildIndex(index);
            if(leftChild(index) < rightChild(index)){
                biggerChildIndex = getRightChildIndex(index);
            }
            if(data[index] < data[biggerChildIndex]){
                swap(data, index, biggerChildIndex);
            } else {
                break;
            }
            index = biggerChildIndex;
        }
    }


}
