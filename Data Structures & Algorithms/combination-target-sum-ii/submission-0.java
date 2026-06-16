class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        cSum(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    public void cSum(int index, int[] candidates, int target, List<Integer> cur, List<List<Integer>> res){
        if(target == 0){
                res.add(new ArrayList<>(cur));
                return;
        }

        for(int i = index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }

            cur.add(candidates[i]);
            cSum(i + 1, candidates, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
