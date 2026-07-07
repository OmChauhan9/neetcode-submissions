class MyHashSet {

    boolean[] check;
    public MyHashSet() {
        check = new boolean[1000001];
    }
    
    public void add(int key) {
        check[key] = true;
    }
    
    public void remove(int key) {
        check[key] = false;
    }
    
    public boolean contains(int key) {
        return check[key] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */