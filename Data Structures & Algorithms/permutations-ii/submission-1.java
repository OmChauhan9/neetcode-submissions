class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        check(nums, ls, ans, vis);
        return ans;
    }

    public void check(int[] nums, List<Integer> ls, List<List<Integer>> ans, boolean[] vis){
        if(ls.size() == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && vis[i-1] == false) continue;
            if(!vis[i]){
                ls.add(nums[i]);
                vis[i] = true;
                check(nums, ls, ans, vis);
                vis[i] = false;
                ls.remove(ls.size() - 1);
            }
        }
    }
}