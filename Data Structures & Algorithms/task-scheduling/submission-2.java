class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char task : tasks){
            mp.put(task, mp.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(Map.Entry<Character, Integer> entry : mp.entrySet()){
            pq.add(entry.getValue());
        }

        int time = 0;

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            // int taskCnt = 0;

            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--;
                    temp.add(freq);
                    // taskCnt++;
                }
            }

            for(int i=0; i<temp.size(); i++){
                if(temp.get(i) > 0){
                    pq.add(temp.get(i));
                }
            }

            if(pq.isEmpty()){
                time += temp.size();
            }else{
                time += n + 1;
            }
        }

        return time;
    }
}
