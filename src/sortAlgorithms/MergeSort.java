package sortAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] A, int low, int high){
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(A, 0, mid-1);
            mergeSort(A,mid+1,high);
            merge(A, low, mid, high);
        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    public static void merge(int[] A, int low, int mid, int high){
        int k=0;
        int i = low;
        int j = mid+1;
        int[] temp = new int[A.length];
        while(i <=mid && j <= high) {
            if(A[i] < A[j]) {
                temp[k++] = A[i];
            } else {
                temp[k++] = A[j];
            }
        }
        while(i<=mid) {
            temp[k++] = A[i];
        }
        while(j<= high) {
            temp[k++] = A[j];
        }

        for(int x = 0; x < temp.length; x++) {
            A[x+low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,4,5};
        mergeSort(A,0, A.length-1);
    }
}
