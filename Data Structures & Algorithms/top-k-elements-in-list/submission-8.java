class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int index = 0;
        while(pq.size() > 0){
            int[] top = pq.poll();
            result[index++] = top[0];
        }

        return result;
    }
}
