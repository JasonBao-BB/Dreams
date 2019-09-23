package HashMap;

import java.util.BitSet;

public class BloomFilter {
    private static final int DEFAULT_SIZE = 1 << 25;
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private static final int[] seeds = new int[]{5,7,11,13,37,61};
    private HashFunction[] functions = new HashFunction[seeds.length];

    public static class HashFunction{
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }
        public int hash(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res = res * seed + s.charAt(i);
            }
            return (capacity - 1) & res;
        }
    }

    public BloomFilter() {
        for(int i=0; i<seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String s) {
        for(HashFunction function : functions) {
            bits.set(function.hash(s), true);
        }
    }

    public boolean contains(String value) {
        if(value == null) {
            return false;
        }
        boolean res = true;
        for(HashFunction function : functions) {
            res = res && bits.get(function.hash(value));
        }
        return res;
    }
}
