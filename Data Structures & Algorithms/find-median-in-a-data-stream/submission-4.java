class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }else if(minHeap.size() + 1 < maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int total = maxHeap.size() + minHeap.size();

        if(total % 2 != 0){
            return (double) maxHeap.peek();
        }else{
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
