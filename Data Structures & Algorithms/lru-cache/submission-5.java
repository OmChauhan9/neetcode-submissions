public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    private Map<Integer, Node> mp;
    private int cap;
    private Node head;
    private Node tail;
 

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.mp = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        Node node = mp.get(key);
        deleteNode(node);
        insertAH(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            deleteNode(node);
            insertAH(node);
        }
        else{
            if(mp.size() >= cap){
                Node node = tail.prev;
                mp.remove(node.key);
                deleteNode(node);
            }

            Node node = new Node(key,value);
            mp.put(key,node);
            insertAH(node);
        }
    }

    private void deleteNode(Node node){
        Node prevN = node.prev;
        Node afterN = node.next;
        prevN.next = afterN;
        afterN.prev = prevN;
    }

    private void insertAH(Node node){
        Node nextN = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextN;
        nextN.prev = node;
        mp.put(node.key, node);
    }
}
