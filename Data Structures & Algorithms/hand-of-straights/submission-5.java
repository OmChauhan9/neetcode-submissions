class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        TreeMap<Integer, Integer> tmp = new TreeMap<>();
        for(int i=0; i<n; i++){
            tmp.put(hand[i], tmp.getOrDefault(hand[i], 0) + 1);
        }

        while(tmp.size() > 0){
            int firstEle = tmp.firstKey();
            tmp.put(firstEle, tmp.getOrDefault(firstEle, 0) - 1);
            if(tmp.getOrDefault(firstEle, 0) == 0){
                tmp.remove(firstEle);
            }

            for(int i=1; i<groupSize; i++){
                int nextEle = firstEle + i;

                if(!tmp.containsKey(nextEle)) return false;

                tmp.put(nextEle, tmp.getOrDefault(nextEle, 0) - 1);
                if(tmp.getOrDefault(nextEle, 0) == 0){
                    tmp.remove(nextEle);
                }
            }
        }

        return true;
    }
}
