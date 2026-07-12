class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1; j<n-2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                int x = j+1;
                int y = n-1;

                while(x < y){
                    long sum = (long)nums[i] + nums[j] + nums[x] + nums[y];

                    if(sum > target) y--;
                    else if(sum < target) x++;
                    else{
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[x], nums[y])));
                        while(y > x && nums[y] == nums[y-1]) y--;
                        x++;
                        y--;
                        // while(y > x && nums[y] == nums[y+1]) y--;
                        // while(y > x && nums[x] == nums[x-1]) x++;
                    }
                }
            }
        }

        return ans;
    }
}