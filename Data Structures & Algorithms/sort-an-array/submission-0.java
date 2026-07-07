class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<n; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int j=0;
        for(int i=min; i<=max; i++){
            if(count.containsKey(i)){
                while(count.get(i) > 0){
                nums[j++] = i;
                count.put(i, count.getOrDefault(i, 0) - 1);
                }
            }
        }

        return nums;
    }
}