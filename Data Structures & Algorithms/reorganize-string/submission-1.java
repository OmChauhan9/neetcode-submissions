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
            Character chr = top.ch;
            int freq = top.number;
            sb.append(chr);
            freq--;

            Pair top1 = pq.poll();
            Character chr1 = top1.ch;
            int freq1 = top1.number;
            sb.append(chr1);
            freq1--;

            if(freq > 0){
                pq.add(new Pair(chr, freq));
            }

            if(freq1 > 0){
                pq.add(new Pair(chr1, freq1));
            }
        }

        if(!pq.isEmpty()){
            Pair top = pq.poll();
            sb.append(top.ch);
        }

        return sb.toString();

    }
}