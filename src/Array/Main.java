package Array;
import Array.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for(int i=0; i<50; i += 2) {
            list.add(i);
        }
        list.print();
    }
}
