class Solution {
    public int search(int[] nums, int target) {
        // int low = 0;
        // int high = nums.length;

        // while(low <= high){
        //     int mid =  low + (high - low)/2;
        //     if(nums[mid] == target){
        //         return mid;
        //     }
        //     else if(target > nums[mid]){
        //         low = mid + 1;
        //     }
        //     else if(target < nums[mid]){
        //         high = mid - 1;
        //     }
        // }
        // return -1;
        return recursive(nums,0,nums.length - 1,target);
    }

    public int recursive(int[] nums,int low,int high,int target){

        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(target == nums[mid]){
            return mid;
        }
        else if(target < nums[mid]){
            return recursive(nums,low,mid-1,target);
        }

        return recursive(nums,mid+1,high,target);   
    }
}

