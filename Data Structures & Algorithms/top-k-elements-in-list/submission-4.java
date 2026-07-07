class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<n; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // PriorityQueue<Integer> kElements = new PriorityQueue<>((a, b) -> Integer.compare(count.get(a), count.get(b)));
        List<Integer> ls = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            ls.add(entry.getKey());
            // if(kElements.size() > k){
            //     kElements.poll();
            // }
        }

        ls.sort((a, b) -> Integer.compare(count.get(b), count.get(a)));

        int[] ans = new int[k];
        // int index = 0;
        // while(kElements.size() > 0){
        //     ans[index++] = kElements.poll();
        // }
        for(int i=0; i<k; i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}
