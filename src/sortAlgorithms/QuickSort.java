package sortAlgorithms;

import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] A, int left, int right) {
        if(left < right) {
            int pivot = partition(A, left, right);
            sort(A, left, pivot-1);
            sort(A, pivot+1, right);
        }
        System.out.println(Arrays.toString(A));
    }

    private int partition2(int[] A, int left, int right) {
        int pivot = A[left];
        int l = left+1;
        int r = right;

        while(l < right) {
            if(A[l] > pivot && A[r] < pivot){
                swap(A, A[l], A[r]);
                l++;
                r--;
            }
            if(A[l] <= pivot) {
                l++;
            }
            if(A[r] >= pivot) {
                r--;
            }
        }
        swap(A, left, r);
        return r;
    }

    private static void swap(int[] A, int left, int right){
        int t = A[left];
        A[left] = A[right];
        A[right] = t;
    }
    private static int partition(int[] A, int left, int right) {
        int pivotIndex = left;
        int pivot = A[pivotIndex];
        int l = left+1;
        int r = right;
        while (l <= r) {
            if(A[l] > pivot && A[r] < pivot) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
            if(A[l] <= pivot){
                l++;
            }
            if(A[r] >= pivot) {
                r--;
            }
        }
        int temp = A[r];
        A[r] = A[pivotIndex];
        A[pivotIndex] = temp;
        return r;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,4,5};
        sort(a,0,a.length-1);
    }
}
