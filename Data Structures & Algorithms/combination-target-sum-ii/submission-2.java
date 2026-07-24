class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        cSum(candidates, target, ans, ls, 0, 0);
        return ans;
    }

    public void cSum(int[] nums, int target, List<List<Integer>> ans, List<Integer> ls, int sum, int index){
        if(sum == target){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if(sum + nums[i] > target) break;
            if(sum < target){
                ls.add(nums[i]);
                cSum(nums, target, ans, ls, sum + nums[i], i + 1);
                ls.remove(ls.size() - 1);
            }
        }
    }
}
