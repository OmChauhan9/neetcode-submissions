class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        if(nums[low] <= nums[high]){
            return nums[low];
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[0] > nums[mid]){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return nums[ans];
    }
}
