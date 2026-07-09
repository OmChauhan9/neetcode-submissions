class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] > 0) k--;
                else if(nums[i] + nums[j] + nums[k] < 0) j++;
                else{
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(k > j && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
            }
        }

        return ans;
    }
}
