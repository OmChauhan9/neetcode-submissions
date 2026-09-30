class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> mp;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            delete(node);
            insert(node);
        }else{
            if(mp.size() == size){
                Node least = tail.prev;
                delete(least);
                mp.remove(least.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            mp.put(key, newNode);
        }
    }

    public void delete(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    public void insert(Node node){
        Node nextN = head.next;

        node.next = nextN;
        node.prev = head;

        head.next = node;
        nextN.prev = node;
    }
}
