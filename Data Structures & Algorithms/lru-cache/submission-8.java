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
            mp.put(key, node);
        }else{
            if(mp.size() == size){
                Node newNode = tail.prev;
                delete(newNode);
                mp.remove(newNode.key);
            }
            Node node = new Node(key, value);
            insert(node);
            mp.put(key, node);
        }
    }

    public void delete(Node node){
        Node prev = node.prev;
        Node after = node.next;
        after.prev = prev;
        prev.next = after;
    }

    public void insert(Node node){
        Node nextN = head.next;

        head.next = node;
        nextN.prev = node;
        node.next = nextN;
        node.prev = head;
        
    }
}
