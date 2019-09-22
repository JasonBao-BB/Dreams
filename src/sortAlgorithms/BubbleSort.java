package sortAlgorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSortBest(int[] A) {
        boolean flag = false;

        for (int i=0; i<A.length-1; i++) {
            flag = false;
            System.out.println("当前第"+ (i+1)+"轮" + Arrays.toString(A));
            for (int j=0; j<A.length-1-i; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    flag = true;
                }
                System.out.println("当前第"+(i+1)+"轮"+ Arrays.toString(A));
            }

            if (!flag) {
                break;
            }
        }

    }

    public static void bubbleSort(int[] A) {
        for (int i=0; i<A.length-1; i++) {
            System.out.println("当前第"+ (i+1)+"轮" + Arrays.toString(A));
            for (int j=0; j<A.length-1-i; j++) {
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
                System.out.println("当前第"+(i+1)+"轮"+ Arrays.toString(A));
            }
        }

    }
}
