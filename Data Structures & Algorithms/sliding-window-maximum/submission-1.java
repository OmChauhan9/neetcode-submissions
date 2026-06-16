class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n == 0 || k == 0 || k > n) {
            return new int[0];
        }

        int[] maxWin = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            // System.out.println("dq :: " + dq);
            if(!dq.isEmpty() && dq.getFirst() <= i-k){
                // System.out.println("dq :: " + dq);
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                // System.out.println("dq-123 :: " + dq);
                dq.removeLast();
            }

            dq.addLast(i);
            // System.out.println("dq :: " + dq);

            if(i >= k-1){
                int resIdx = i - k + 1;
                maxWin[resIdx] = nums[dq.peekFirst()];
            }
        }

        return maxWin;
        // for(int i = 0; i<n-k+1;i++){
        //     int max = nums[i];
        //     for(int j = i; j<i+k; j++){
        //         max = Math.max(max,nums[j]);
        //     }
        //     System.out.println("max ::: " + max);
        //     maxWin[i] = max;
        // }
        // return maxWin;
    }
}
