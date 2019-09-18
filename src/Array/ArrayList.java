package Array;

public class ArrayList {
    private int size;
    private int[] data;
    public ArrayList(int capacity){
        this.size = 0;
        this.data = new int[capacity];
    }
    public ArrayList() {
        this(4);
    }

    public void add(int num) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size] = num;
        size++;
    }

    public void add(int index, int num) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index wrong");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }
        // i is last one
        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = num;
    }

    public boolean contains(int num) {
        for (int i=0; i<data.length; i++) {
            if (data[i] == num) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index wrong");
        }
       return data[index];
    }

    public void set(int index, int num) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index wrong");
        }
        data[index] = num;
    }

    public int remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index wrong");
        }
        for(int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        if(data.length / 4 == size && data.length/2 != 0) {
            resize(data.length/2);
        }
        return data[index];
    }

    public int removeElement(int num) {
        int index = -1;
        for(int i=0; i<data.length; i++) {
            if(data[i] == num) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Element is not exsis");
        }
        remove(index);
        return  0;
    }

    public void print() {
        System.out.println("size: "+ size);
        System.out.println("capacity: "+ data.length);
        for (int i=0; i<size; i++) {
            System.out.println(data[i]);
        }
    }

    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for(int i=0; i<size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
