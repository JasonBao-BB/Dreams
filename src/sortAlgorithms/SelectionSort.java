package sortAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void seletionSort(int[] A){

        for(int i=0; i<A.length-1; i++) {
            int min = i;
            for(int j=i+1; j<A.length; j++) {
                if(A[j] < A[min]) {
                    min = j;
                }
            }
            if(i != min) {
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] a = {9,8,7};
        seletionSort(a);

    }
}
