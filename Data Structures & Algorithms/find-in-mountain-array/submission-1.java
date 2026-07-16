/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // Finding peak element index
        int peak = 0;
        if(mountainArr.get(0) > mountainArr.get(1)) peak = 0;
        if(mountainArr.get(n-1) > mountainArr.get(n-2)) peak = n - 1;

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(mountainArr.get(mid - 1) < mountainArr.get(mid) && mountainArr.get(mid) > mountainArr.get(mid + 1)){
                peak = mid;
                break;
            }else if(mountainArr.get(mid) > mountainArr.get(mid - 1)) low = mid + 1;
            else high = mid - 1;
        }


        // Now, Finding target in increasing slope
        int low1 = 0;
        int high1 = peak;

        while(low1 <= high1){
            int mid = low1 + (high1 - low1)/2;

            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) > target) high1 = mid - 1;
            else low1 = mid + 1;
        } 


        // Now, Finding target imn decreasing slope

        int low2 = n - 1;
        int high2 = peak + 1;

        while(high2 <= low2){
            int mid = high2 + (low2 - high2)/2;

            if(mountainArr.get(mid) == target) return mid;
            else if(mountainArr.get(mid) > target) high2 = mid + 1;
            else low2 = mid - 1; 
        }

        return -1;

    }
}