class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ls = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            ls.add(entry.getKey());
        }

        ls.sort((a, b) -> Integer.compare(count.get(b), count.get(a)));

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}
