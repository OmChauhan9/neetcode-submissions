class Pair{
    String word;
    int count;

    public Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>(wordList);

        if(!st.contains(endWord)) return 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair top = q.poll();
            String word = top.word;
            int count = top.count;

            if(word.equals(endWord)) return count;

            char[] chr = word.toCharArray();
            for(int i=0; i<chr.length; i++){
                char original = chr[i];
                for(char c='a'; c<='z'; c++){
                    chr[i] = c;
                    String newWord = new String(chr);

                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new Pair(newWord, count + 1));
                    }
                }

                chr[i] = original;
            }
        }

        return 0;

    }
}
