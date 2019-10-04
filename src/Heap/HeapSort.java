package Heap;

public class HeapSort {
    public static void heapSort(int[] data){
        for(int i=data.length-1; i>=0; i--){
            siftDown(data, i, data.length);
        }

        for(int i = data.length-1; i>0; i--){
            swap(data, i, 0);
            siftDown(data, 0, i);
        }
    }

    private static void siftDown(int[] data, int index, int length){
        int child = index*2+1;
        while(child < length){
            if(child+1 < length && data[child] < data[child+1]){
                child = child+1;
            }
            if(data[index] < data[child]){
                swap(data, index, child);
            } else {
                break;
            }
            index = child;
        }
    }

    private static void swap(int[] data, int i, int j){
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
