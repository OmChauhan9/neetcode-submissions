class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
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
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        Node node = mp.get(key);
        delete(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            delete(node);
            insertAfterHead(node);
        }else{
            if(mp.size() == size){
                Node node = tail.prev;
                mp.remove(node.key);
                delete(node);
            }
            Node newNode = new Node(key, value);
            mp.put(key, newNode);
            insertAfterHead(newNode);
        }
    }

    public void delete(Node node){
        Node prevN = node.prev;
        Node nextN = node.next;
        prevN.next = nextN;
        nextN.prev = prevN;
    }

    public void insertAfterHead(Node node){
        Node nextN = head.next;

        node.next = nextN;
        node.prev = head;

        head.next = node;
        nextN.prev = node;

    }
}
