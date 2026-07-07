class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue() > n/3){
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}