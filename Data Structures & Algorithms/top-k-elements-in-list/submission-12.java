class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        List<Integer>[] freq = new List[n + 1];
        for(int i=0; i<=n; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i=n; i>=0; i--){
            for(int num : freq[i]){
                res[index++] = num;
                if(index == k) return res;
            }
        }

        return new int[]{};

    }
}
