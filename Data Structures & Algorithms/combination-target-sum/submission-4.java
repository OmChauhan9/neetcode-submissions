class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        sum(nums, ls, ans, target, 0);
        return ans;
    }

    public void sum(int[] nums, List<Integer> ls, List<List<Integer>> ans, int target, int index){
        if(target <= 0){
            if(target == 0){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        for(int i=index; i<nums.length; i++){
            ls.add(nums[i]);
            sum(nums, ls, ans, target - nums[i], i);
            ls.remove(ls.size() - 1);
        }


    }
}
