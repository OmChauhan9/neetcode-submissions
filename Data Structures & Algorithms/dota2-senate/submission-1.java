class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }

        while(r.size() > 0 && d.size() > 0){
            int rt = r.poll();
            int dt = d.poll();

            if(rt > dt) d.add(dt + n);
            else r.add(rt + n);
        }

        return r.size() > 0 ? "Radiant" : "Dire";
    }
}