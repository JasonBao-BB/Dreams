package sortAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void sort(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int bucketNum = (max - min)/A.length + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0; i<bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        for(int i=0; i<A.length; i++) {
            int count = (A[i] - min)/A.length;
            buckets.get(count).add(A[i]);
        }

        for(int i=0; i<buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        System.out.println(buckets.toString());
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,4,5};
        sort(a);
    }
}
