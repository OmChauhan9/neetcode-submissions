class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(a) - mp.get(b));
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = pq.poll(); 
        }

        return result;
    }
}
