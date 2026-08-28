class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        List<Integer>[] ls = new List[n + 1];
        for(int i=0; i<=n; i++){
            ls[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            ls[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i = n; i>=0; i--){
            for(int num : ls[i]){
                res[idx++] = num;
                if(idx == k) return res;
            }
        }

        return new int[]{};
    }
}
