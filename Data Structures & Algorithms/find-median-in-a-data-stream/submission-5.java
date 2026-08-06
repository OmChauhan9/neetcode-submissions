class MedianFinder {
    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;

    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(max_heap.isEmpty() || num <= max_heap.peek()){
            max_heap.add(num);
        }else{
            min_heap.add(num);
        }

        if(max_heap.size() > min_heap.size() + 1){
            min_heap.add(max_heap.poll());
        }else if(min_heap.size() > max_heap.size()){
            max_heap.add(min_heap.poll());
        }
    }
    
    public double findMedian() {


        if(max_heap.size() > min_heap.size()){
            return (double) max_heap.peek();
        }else{
            return (double) (max_heap.peek() + min_heap.peek()) / 2;
        }
    }
}
