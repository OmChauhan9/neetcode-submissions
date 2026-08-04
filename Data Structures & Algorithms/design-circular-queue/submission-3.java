class MyCircularQueue {

    int[] cq;
    int front;
    int rear;
    int size;
    int cqSizeCnt;

    public MyCircularQueue(int k) {
        cq = new int[k];
        front = -1;
        rear = -1;
        size = k;
        cqSizeCnt = 0;
    }
    
    public boolean enQueue(int value) {
        if(cqSizeCnt == size) return false;

        rear = (rear + 1) % size;
        cq[rear] = value;
        cqSizeCnt++;
        return true;
    }
    
    public boolean deQueue() {
        if(cqSizeCnt == 0) return false;

        front = (front + 1) % size;
        cq[front] = -1;
        cqSizeCnt--;
        return true;
    }
    
    public int Front() {
        if(cqSizeCnt == 0) return -1;
        return cq[(front + 1) % size];
    }
    
    public int Rear() {
        if(cqSizeCnt == 0) return -1;
        return cq[rear];
    }
    
    public boolean isEmpty() {
        return cqSizeCnt == 0;
    }
    
    public boolean isFull() {
        return cqSizeCnt == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */