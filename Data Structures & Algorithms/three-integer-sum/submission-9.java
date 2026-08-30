class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] > 0) k--;
                else if(nums[i] + nums[j] + nums[k] < 0) j++;
                else{
                    ls.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;

                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ls;
    }
}
