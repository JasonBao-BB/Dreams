package sortAlgorithms;

public class Main {
    public static void main(String[] args) {
        int[] a = {9,8,7};
        int[] a1 = {1,2,3};
        //BubbleSort.bubbleSortBest(a1);
        //SelectionSort.seletionSort(a);
        InsertionSort.sort(a);
        for(int num : a) {
            System.out.println(num);
        }
    }
}
