package sortAlgorithms;

import java.util.Arrays;

public class CountSort {
    public static void sort(int[] A){
        int max = Integer.MIN_VALUE;

        for(int num : A) {
            max = Math.max(max, num);
        }

        int[] temp = new int[max+1];

        for(int i=0; i<A.length; i++) {
            temp[A[i]] = temp[A[i]]+1;
        }

        int index = 0;
        for(int j=0; j<=max; j++) {
            for(int k=0; k<temp[j]; k++) {
                A[index++] = j;
            }
        }

        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,4,5};
        sort(a);
    }
}
