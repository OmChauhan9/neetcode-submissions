class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        cSum(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    public void cSum(int index, int[] nums, int target, List<Integer> cur, List<List<Integer>> res){
        
        if(index == nums.length){
            if(target == 0){
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        if(nums[index] <= target){
            cur.add(nums[index]);
            cSum(index, nums, target - nums[index], cur, res);
            cur.remove(cur.size() - 1);
        }
        
        cSum(index + 1, nums, target, cur, res);
    }
}
