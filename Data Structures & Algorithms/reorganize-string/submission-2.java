class Pair{
    Character ch;
    int number;

    Pair(Character ch, int number){
        this.ch = ch;
        this.number = number;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        int limit = (n + 1)/2;
        for(int num : mp.values()){
            if(num > limit) return "";
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.number - a.number);
        for(Map.Entry<Character, Integer> entry : mp.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){
            Pair top = pq.poll();
            Pair top1 = pq.poll();

            sb.append(top.ch);
            sb.append(top1.ch);

            top.number--;
            top1.number--;

            if(top.number > 0){
                pq.add(top);
            }

            if(top1.number > 0){
                pq.add(top1);
            }
        }

        if(!pq.isEmpty()){
            Pair top = pq.poll();
            sb.append(top.ch);
        }

        return sb.toString();

    }
}