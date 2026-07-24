class MedianFinder {

    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;

    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(max_heap.size() == 0 || num <= max_heap.peek()){
            max_heap.add(num);
        }else{
            min_heap.add(num);
        }

        if(max_heap.size() < min_heap.size()){
            max_heap.add(min_heap.poll());
        }else if(min_heap.size() + 1 < max_heap.size()){
            min_heap.add(max_heap.poll());
        }
    }
    
    public double findMedian() {
        if(max_heap.size() == min_heap.size()){
            int max_top = max_heap.peek();
            int min_top = min_heap.peek();

            return (double)(max_top + min_top)/2;
        }else{
            return (double)(max_heap.peek());
        }
    }
}
