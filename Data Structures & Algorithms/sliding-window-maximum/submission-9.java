class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];

        // Storing Index.
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            if(!q.isEmpty() && i - k + 1 > q.peekFirst()){
                q.pollFirst();
            }

            q.addLast(i);

            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}
