class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int ele = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(cnt == 0){
                cnt = 1;
                ele = nums[i];
            }else if(nums[i] == ele) cnt++;
            else cnt--;
        }

        int ansCnt = 0;
        for(int num : nums){
            if(num == ele) ansCnt++;
        }

        return ansCnt > n/2 ? ele : -1;
    }
}