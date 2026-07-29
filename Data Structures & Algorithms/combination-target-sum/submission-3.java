class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        sum(nums, target, ls, ans, 0);
        return ans;
    }

    public void sum(int[] nums, int target, List<Integer> ls, List<List<Integer>> ans, int index){
        if(target <= 0){
            if(target == 0){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        for(int i=index; i<nums.length; i++){
            ls.add(nums[i]);
            sum(nums, target - nums[i], ls, ans, i);
            ls.remove(ls.size() - 1);
        }
    }
}
