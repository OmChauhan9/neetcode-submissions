class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        for(int st: set){
            if(!set.contains(st - 1)){
                int count = 1;
                int lastSmall = st;
                while(set.contains(lastSmall+1)){
                    count += 1;
                    lastSmall += 1;
                }
            longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}
