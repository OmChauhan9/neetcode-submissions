class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        sum(candidates, ls, ans, target, 0);
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
            if(i > index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) return;
            ls.add(nums[i]);
            sum(nums, ls, ans, target - nums[i], i + 1);
            ls.remove(ls.size() - 1);
        }


    }
}
