class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        cSum(nums, target, ans, ls, 0, 0);
        return ans;
    }

    public void cSum(int[] nums, int target, List<List<Integer>> ans, List<Integer> ls, int sum, int index){
        if(index >= nums.length) return;
        if(sum >= target){
            if(sum == target){
                ans.add(new ArrayList<>(ls));
                return;
            }else{
                return;
            }
        }

        if(sum <= target){
            ls.add(nums[index]);
            cSum(nums, target, ans, ls, sum + nums[index], index);
            ls.remove(ls.size() - 1);
            cSum(nums, target, ans, ls, sum, index+1);
        }
    }
}
