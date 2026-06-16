class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Set<List<Integer>> result = new HashSet<>();
        // for(int i = 0; i<n-2; i++){
        //     for(int j = i+1; j<n-1; j++){
        //         for(int k = j+1; k<n; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 result.add(Arrays.asList(nums[i],nums[j],nums[k]));
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;

            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                        // if(nums[left] == nums[left-1]){
                        //     left++;
                        // }
                        // else if(nums[right] == nums[right-1]){
                        //     right--;
                        // }
                    }
                }
            }
        }
        return result;
    }
}
