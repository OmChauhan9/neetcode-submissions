class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);

        int cnt = 1;
        int max = 0;
        for(int i=0; i<n; i++){
            if(!st.contains(nums[i] - 1));{
                int current = nums[i];
                while(st.contains(current + 1)){
                    cnt++;
                    current = current + 1;
                }
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }

        return max;
    }
}
