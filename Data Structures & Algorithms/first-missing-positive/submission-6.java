class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            max = Math.max(num, max);
            min = Math.min(num, min);
            set.add(num);
        }

        for(int i=1; i<=max; i++){
            if(set.contains(i)) continue;
            else{
                if(i > 0) return i;
                else continue;
            }
        }

        return max < 0 ? 1 : max + 1;
    }
}