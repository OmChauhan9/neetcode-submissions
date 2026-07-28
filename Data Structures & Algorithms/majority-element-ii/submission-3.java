class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

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

        int ansCnt1 = 0;
        int ansCnt2 = 0;
        for(int i=0; i<n; i++){
            if(ele1 == nums[i]) ansCnt1++;
            else if(ele2 == nums[i]) ansCnt2++;
        }

        List<Integer> ls = new ArrayList<>();
        if(ansCnt1 > n/3) ls.add(ele1);
        if(ansCnt2 > n/3) ls.add(ele2);

        return ls;
    }
}