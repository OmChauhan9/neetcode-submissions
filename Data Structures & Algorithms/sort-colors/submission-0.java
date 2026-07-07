class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int j=0;
        for(int i=0; i<=2; i++){
            if(count.containsKey(i)){
                while(count.get(i) > 0){
                    nums[j++] = i;
                    count.put(i, count.getOrDefault(i, 0) - 1);
                }
            }
        }
    }
}