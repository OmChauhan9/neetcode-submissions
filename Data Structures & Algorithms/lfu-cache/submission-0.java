class Node{
    int key;
    int val;
    int freq;
    Node prev;
    Node next;

    Node(int key, int val){
        this.val = val;
        this.key = key;
        this.freq = 1;
    }
}

class DoublyLL{
    int dlSize;
    Node head;
    Node tail;

    DoublyLL(){
        this.dlSize = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void insert(Node node){
        Node nextN = head.next;

        node.next = nextN;
        node.prev = head;

        head.next = node;
        nextN.prev = node;

        dlSize++;
    }

    public void delete(Node node){
        Node prevN = node.prev;
        Node afterN = node.next;

        prevN.next = afterN;
        afterN.prev = prevN;

        dlSize--;
    }
}

class LFUCache {

    HashMap<Integer, DoublyLL> lfuMP;
    HashMap<Integer, Node> mp;
    int size;
    int minFreq;
    

    public LFUCache(int capacity) {
        size = capacity;
        minFreq = 1;
        lfuMP = new HashMap<>();
        mp = new HashMap<>();

    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (size <= 0) return;

        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            update(node);
        }else{
            if(mp.size() == size){
                DoublyLL minFreqList = lfuMP.get(minFreq);

                Node LRUNode = minFreqList.tail.prev; 
                minFreqList.delete(LRUNode);
                mp.remove(LRUNode.key);
            }

            minFreq = 1;
            Node node = new Node(key, value);
            DoublyLL list = lfuMP.getOrDefault(1, new DoublyLL());
            list.insert(node);
            lfuMP.put(1, list);
            mp.put(key, node);
        }
    }

    public void update(Node node){
        int curFreq = node.freq;
        DoublyLL dll = lfuMP.get(curFreq);
        dll.delete(node);

        if(curFreq == minFreq && dll.dlSize == 0){
            minFreq++;
        }

        node.freq++;
        DoublyLL newList = lfuMP.getOrDefault(node.freq, new DoublyLL());
        newList.insert(node);
        lfuMP.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */