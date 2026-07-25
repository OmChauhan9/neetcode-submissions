class Pair{
    String word;
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair top = q.poll();
            String w = top.word;
            int l = top.level;

            if(w.equals(endWord)) return l;

            char[] cur = w.toCharArray();
            for(int i=0; i<beginWord.length(); i++){
                char original = cur[i];
                for(char ch = 'a'; ch<= 'z'; ch++){
                    cur[i] = ch;
                    String newW = new String(cur);

                    if(set.contains(newW)){
                        q.add(new Pair(newW, l + 1));
                        set.remove(newW);
                    }
                }

                cur[i] = original;
            }
        }

        return 0;
    }
}
