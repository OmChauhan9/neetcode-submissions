class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int i=0; i<n; i++){
            mp.put(hand[i], mp.getOrDefault(hand[i],0) + 1);
        }

        while(!mp.isEmpty()){
            int firstEle = mp.firstKey();
            mp.put(firstEle, mp.getOrDefault(firstEle,0) - 1);

            int value = mp.get(firstEle);

            for(int i=1; i<groupSize; i++){
                int next = firstEle + i;
                if(!mp.containsKey(next)){
                    return false;
                }

                int curCnt = mp.get(next);
                if(curCnt == 1){
                    mp.remove(next);
                }else{
                    mp.put(next, curCnt - 1);
                }
            }

            if(value == 0){
                mp.remove(firstEle);
            }
        }

        System.out.println("mp ::: " + mp);
        return true;
    }
}
