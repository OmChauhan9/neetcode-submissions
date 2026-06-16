class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // if(k == nums.length){
        //     return nums;
        // }

        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i = 0; i<nums.length; i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        // List<int[]> arr = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     arr.add(new int[]{entry.getKey(),entry.getValue()});
        // }

        // arr.sort((a,b) -> b[0] - a[0]);

        // int[] freq = new int[k];
        // for(int j =0; j<k; j++){
        //     freq[j] = arr.get(j)[0];
        // }
        // return freq;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for(int i =0; i<k; i++){
            result[i] = heap.poll()[1];
        }
        return result;
    }
}
