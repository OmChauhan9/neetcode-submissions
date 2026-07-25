class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        per(nums, ans, ls, freq);
        return ans;
    }

    public void per(int[] num, List<List<Integer>> ans, List<Integer> ls, boolean[] freq){
        if(ls.size() == num.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0; i<num.length; i++){
            if(i > 0 && num[i-1] == num[i] && !freq[i-1]) continue;
            if(!freq[i]){
                ls.add(num[i]);
                freq[i] = true;
                per(num, ans, ls, freq);
                ls.remove(ls.size() - 1);
                freq[i] = false;
            }
        }
    }
}