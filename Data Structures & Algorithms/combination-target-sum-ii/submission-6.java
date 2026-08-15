class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        solve(candidates, ls, ans, target, 0);
        return ans;
    }

    public void solve(int[] nums, List<Integer> ls, List<List<Integer>> ans, int target, int index){
        if(target <= 0){
            if(target == 0) ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(nums[i] > target) continue;
            if(i > index && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            solve(nums, ls, ans, target - nums[i], i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}
