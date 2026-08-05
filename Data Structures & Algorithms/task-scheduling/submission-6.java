class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;

        HashMap<Character, Integer> mp = new HashMap<>();
        for(char task : tasks){
            mp.put(task, mp.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(mp.values());

        int cnt = 0;

        while(!pq.isEmpty()){
            List<Integer> ls = new ArrayList<>();

            for(int i=0; i<=n; i++){
                if(!pq.isEmpty()){
                    int top = pq.poll();
                    top--;
                    ls.add(top);
                }
            }

            for(int i=0; i<ls.size(); i++){
                if(ls.get(i) > 0){
                    pq.add(ls.get(i));
                }
            }

            if(pq.size() > 0){
                cnt += n + 1;
            }else{
                cnt += ls.size();
            }
        }

        return cnt;
    }
}
