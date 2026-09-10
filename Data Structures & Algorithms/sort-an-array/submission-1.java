class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) pq.add(num);

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = pq.poll();
        }

        return ans;
    }
}