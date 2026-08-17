class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        HashSet<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        int max = 0;
        for(int i=0; i<n; i++){
            if(!st.contains(nums[i] - 1)){
                int current = nums[i];
                int cnt = 1;
                while(st.contains(current + 1)){
                    cnt++;
                    current++;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
