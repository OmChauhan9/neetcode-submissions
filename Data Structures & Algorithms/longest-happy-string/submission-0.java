class Pair{
    Character ch;
    int num;

    Pair(Character ch, int num){
        this.ch = ch;
        this.num = num;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.num - x.num);

        if(a > 0) pq.add(new Pair('a', a));
        if(b > 0) pq.add(new Pair('b', b));
        if(c > 0) pq.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            Character chr = top.ch;

            int len = sb.length();
            if(len >= 2 && sb.charAt(len - 1) == chr && sb.charAt(len - 2) == chr){
                if(pq.isEmpty()) break;

                Pair nextTop = pq.poll();
                Character nextChr = nextTop.ch;
                sb.append(nextChr);
                nextTop.num--;

                if(nextTop.num > 0){
                    pq.add(nextTop);
                }
            }

            sb.append(chr);
            top.num--;
            if(top.num > 0){
                pq.add(top);
            }

        }

        return sb.toString();
    }
}