class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] max = new int[n-k+1];

        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(dq.size() > 0 && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= k - 1){
                max[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return max;
    }
}
