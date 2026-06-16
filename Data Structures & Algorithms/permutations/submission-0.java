class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        perM(nums, freq, new ArrayList<>(), res);
        return res;
    }

    public void perM(int[] nums, boolean[] freq, List<Integer> cur, List<List<Integer>> res){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                cur.add(nums[i]);
                perM(nums, freq, cur, res);
                cur.remove(cur.size() - 1);
                freq[i] = false;
            }
        }
    }
}
