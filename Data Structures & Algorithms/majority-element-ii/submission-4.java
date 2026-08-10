class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else if(cnt1 == 0){
                ele1 = nums[i];
                cnt1++;
            }else if(cnt2 == 0){
                ele2 = nums[i];
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        int fCnt1 = 0;
        int fCnt2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele1) fCnt1++;
            if(nums[i] == ele2) fCnt2++;
        }

        List<Integer> ls = new ArrayList<>();
        if(fCnt1 > n/3) ls.add(ele1);
        if(fCnt2 > n/3) ls.add(ele2);

        return ls; 
    }
}