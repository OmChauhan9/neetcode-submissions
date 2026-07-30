class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i=0; i<n; i++){
            mp.put(hand[i], mp.getOrDefault(hand[i], 0) + 1);
        }

        while(mp.size() > 0){
            int firstEle = mp.firstKey();

            for(int i=1; i<groupSize; i++){
                int nextEle = firstEle + i;
                if(!mp.containsKey(nextEle)) return false;

                int curCnt = mp.get(nextEle);
                if(curCnt == 1) mp.remove(nextEle);
                else mp.put(nextEle, curCnt - 1);
            }

            mp.put(firstEle, mp.getOrDefault(firstEle, 0) - 1);
            int value = mp.get(firstEle);
            if(value == 0) mp.remove(firstEle);
        }

        return true;
    }
}
