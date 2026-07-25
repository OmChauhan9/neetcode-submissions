class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        sub(nums, ans, ls, 0);
        return ans;
    }

    public void sub(int[] nums, List<List<Integer>> ans, List<Integer> ls, int index){
        ans.add(new ArrayList<>(ls));

        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            ls.add(nums[i]);
            sub(nums, ans, ls, i+1);
            ls.remove(ls.size() - 1);
        }
    }
}
