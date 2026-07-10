class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        if(k == 0) return false;

        int l = 0, r = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        while(r < n){
            if(r - l > k){
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r])) return true;
            set.add(nums[r]);
            r++;
        }

        return false;
    }
}