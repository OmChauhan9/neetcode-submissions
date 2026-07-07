class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int max = -1;
        int maxNum = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                maxNum = entry.getKey();
            }
        }

        return maxNum;

    }
}