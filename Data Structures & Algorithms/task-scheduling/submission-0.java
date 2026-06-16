class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> mp = new HashMap<>();

        for(char task : tasks){
            mp.put(task, mp.getOrDefault(task,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.addAll(mp.values());

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            for(int i = 0; i<= n; i++){
                if(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }

            for(int cnt : ls){
                if(--cnt > 0){
                    pq.add(cnt);
                }
            }

            time += pq.isEmpty() ? ls.size() : n+1;
        }

        return time;

    }
}
