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
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        size = capacity;

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
                Node lastNode = tail.prev;
                delete(lastNode);
                mp.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            mp.put(key, newNode);
        }
    }

    public void delete(Node node){
        Node after = node.next;
        Node before = node.prev;

        after.prev = before;
        before.next = after;
    }

    public void insert(Node node){
        Node nextN = head.next;

        node.next = nextN;
        node.prev = head;

        head.next = node;
        nextN.prev = node;
    }
}
