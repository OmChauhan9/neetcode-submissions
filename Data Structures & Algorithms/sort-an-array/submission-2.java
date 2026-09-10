class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[n];
        int idx = 0;
        for(int i=min; i<=max; i++){
            while(mp.containsKey(i)){
                ans[idx++] = i;
                mp.put(i, mp.getOrDefault(i, 0) - 1);
                if(mp.get(i) == 0) mp.remove(i);
            }
        }

        return ans;
    }
}