class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(b) - mp.get(a));
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(entry.getKey());
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}
