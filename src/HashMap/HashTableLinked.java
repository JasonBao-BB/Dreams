package HashMap;

public class HashTableLinked<K, V> {
    class Node<K, V>{
        K key;
        V value;
        Node next;
        Node pre;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
    int size;
    int capacity;
    Node[] nodes;

    public HashTableLinked(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        nodes = new Node[capacity];
    }
    public HashTableLinked() {
        this.size = 0;
        this.capacity = 10;
        nodes = new Node[capacity];
    }

    public V get(K key) {
        Node node = nodes[hash(key)];
       while(node != null) {
           if(node.key.equals(key)) {
               return (V) node.value;
           }
           node = node.next;
       }
        return null;
    }

    public void put(K key, V value) {
        Node node = new Node(key, value);
        int index = hash(key);
        Node curNode = nodes[index];
        Node preNode = null;
        if(curNode == null) {
            nodes[index] = node;
        } else {
            while (curNode != null) {
                if(curNode.key.equals(key)) {
                    curNode.value = value;
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = node;
        }
        size++;
    }

    public V delete(K key) {
        Node node = nodes[hash(key)];
        Node preNode = null;
        while (node != null) {
            if(node.key.equals(key)) {
                break;
            }
            preNode = node;
            node = node.next;
        }
        if(node == null) {
            return null;
        } else {
           preNode.next = node.next;
        }
        size--;
        return (V) node.value;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
}
