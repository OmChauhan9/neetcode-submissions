class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);

        for(int i = 0; i<nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.offer(val);
        } 
        else if(val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
