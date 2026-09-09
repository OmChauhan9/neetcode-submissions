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

        // int majEle = ele;
        // int finalCnt = 0;
        // for(int num : nums){
        //     if(num == majEle) finalCnt++;
        // }

        // return finalCnt >= n/2 ? majEle : 0;
        return ele;
    }
}