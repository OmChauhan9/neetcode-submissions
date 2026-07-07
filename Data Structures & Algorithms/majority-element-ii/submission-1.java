class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else if(cnt1 == 0){
                cnt1 = 1;
                ele1 = nums[i];
            }else if(cnt2 == 0){
                cnt2 = 1;
                ele2 = nums[i];
            }else{
                cnt1--;
                cnt2--;
            }
        }

        int anCnt1 = 0, anCnt2 = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) anCnt1++;
            else if(nums[i] == ele2) anCnt2++;
        }

        List<Integer> ans = new ArrayList<>();
        if(anCnt1 > n/3) ans.add(ele1);
        if(anCnt2 > n/3) ans.add(ele2);

        return ans;
    }
}