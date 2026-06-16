class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0; i<nums.length;i++){
            int num = nums[i];
            int diff = target - num;

            if(mp.containsKey(diff)){
                return new int[]{mp.get(diff),i};
            }
            mp.put(num,i);
        }
        return new int[]{};
    }
}
