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

class LRUCache{

    HashMap<Integer, Node> mp;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity){
        mp = new HashMap<>();
        size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!mp.containsKey(key)) return -1;

        Node curr = mp.get(key);
        delete(curr);
        insert(curr);
        return curr.val;
    }

    public void put(int key, int value){
        if(mp.containsKey(key)){
            Node curr = mp.get(key);
            curr.val = value;
            delete(curr);
            insert(curr);
            mp.put(key, curr);
        }else{
            if(mp.size() == size){
                Node nodeToDel = tail.prev;
                delete(nodeToDel);
                mp.remove(nodeToDel.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            mp.put(key, newNode);
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

        node.next = nextN;
        node.prev = head;

        head.next = node;
        nextN.prev = node;
    }
}
