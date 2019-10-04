package HashMap;

public class HashMapOpenAddress<K, V> {
    class Node<K, V>{
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    Node[] nodes;

    public HashMapOpenAddress(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        nodes = new Node[capacity];
    }
    public HashMapOpenAddress(){
        this.size = 0;
        this.capacity = 10;
        nodes = new Node[capacity];
    }
    private int hash(K key){
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        int startIndex = index;
        while(nodes[index] != null) {
            if(nodes[index].key.equals(key)) {
                nodes[index].value = value;
                return;
            }
            index++;
            index = index % capacity;
            if(index == startIndex) {
                resize();
                index = 0;
            }
        }
        nodes[index] = new Node(key, value);
        size++;
    }

    public V get(K key){
        int index = hash(key);
        while (nodes[index] != null) {
            if(nodes[index].key.equals(key)) {
                return (V) nodes[index].value;
            }
            index++;
            index = index % capacity;
        }
        return null;
    }

    public V delete(K key) {
        int index = hash(key);

        while(nodes[index] != null) {
            if(nodes[index].key.equals(key)) {
                V res = (V) nodes[index].value;
                nodes[index] = null;
                size--;
                return res;
            }
            index++;
            index = index % capacity;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity = capacity * 2;
        Node[] old = nodes;
        nodes = new Node[capacity];
        for(int i=0; i<old.length; i++) {
            if(old[i] != null) {
                put((K)old[i].key, (V) old[i].value);
            }
        }

    }
}
