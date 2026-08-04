class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        // this.next = null;
        // this.prev = null;
    }
}

class LRUCache {

    HashMap<Integer, Node> mp;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        size = capacity;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            delete(node);
            insert(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            delete(node);
            insert(node);
            mp.put(key, node);
        }else{
            if(mp.size() == size){
                Node node = tail.prev;
                delete(node);
                mp.remove(node.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            mp.put(key, newNode);
        }
    }

    public void delete(Node node){
        Node after = node.next;
        Node before = node.prev;
        before.next = after;
        after.prev = before;
    }

    public void insert(Node node){
        Node next = head.next;

        node.next = next;
        node.prev = head;

        head.next = node;
        next.prev = node;
    }
}
