class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> sum_cnt = new HashMap<>();
        int cnt = 0;
        int prefix = 0;
        sum_cnt.put(0, 1);

        for(int i=0; i<n; i++){
            prefix += nums[i];
            int ans = prefix - k;
            if(sum_cnt.containsKey(ans)){
                cnt += sum_cnt.get(ans);
                // sum_cnt.put(ans, sum_cnt.getOrDefault(ans, 0) + 1);

            }
            sum_cnt.put(prefix, sum_cnt.getOrDefault(prefix, 0) + 1);
        }
        return cnt;
    }
}