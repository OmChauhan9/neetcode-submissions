class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = Integer.MIN_VALUE;
        int cnt = 0;

        for(int num : nums){
            if(num == ele) cnt++;
            else if(cnt == 0){
                ele = num;
                cnt = 1;
            }else cnt--;
        }

        int finalCnt = 0;
        for(int num : nums){
            if(num == ele) finalCnt++;
        }

        return finalCnt >= n/2 ? ele : 0;
    }
}