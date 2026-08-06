class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        per(nums, ls, ans, vis);
        return ans;
    }

    public void per(int[] nums, List<Integer> ls, List<List<Integer>> ans, boolean[] vis){
        if(ls.size() == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!vis[i]){
                vis[i] = true;
                ls.add(nums[i]);
                per(nums, ls, ans, vis);
                ls.remove(ls.size() - 1);
                vis[i] = false;
            }
        }
    } 
}
