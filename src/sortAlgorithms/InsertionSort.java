package sortAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] A) {
        for(int i=0; i<A.length-1; i++) {
            for(int j=i; j>0; j--) {
                if(A[j] < A[j-1]) {
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                } else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,4,5};
        sort(a);
    }
}
