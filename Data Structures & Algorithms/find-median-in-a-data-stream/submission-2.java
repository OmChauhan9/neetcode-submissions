class MedianFinder {

    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;
    int count;

    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>((a, b) -> b - a);
        count = 0;
    }
    
    public void addNum(int num) {
        // if(max_heap.size() == 0) max_heap.add(num);
        // else if(min_heap.size() == 0) min_heap.add(num);
        // else{
        //     if(num > max_heap.peek()) min_heap.add(num);
        //     else max_heap.add(num);
        // }
        if(max_heap.size() == 0 || num <= max_heap.peek()){
            max_heap.add(num);
        }else{
            min_heap.add(num);
        }
        count++;

        if(max_heap.size() < min_heap.size()){
            max_heap.add(min_heap.poll());
        }else if(min_heap.size() + 1 < max_heap.size()){
            min_heap.add(max_heap.poll());
        }
    }
    
    public double findMedian() {
        if(count % 2 == 0){
            int max_top = max_heap.peek();
            int min_top = min_heap.peek();

            return (double)(max_top + min_top)/2;
        }else{
            return (double)(max_heap.peek());
        }
    }
}
