class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord)) return 0;

        Set<String> forward = new HashSet<>();
        Set<String> backward = new HashSet<>();

        forward.add(beginWord);
        backward.add(endWord);

        int level = 1;

        while(!forward.isEmpty() && !backward.isEmpty()){
            if(forward.size() > backward.size()){
                Set<String> temp = forward;
                forward = backward;
                backward = temp;
            }

            Set<String> next = new HashSet<>();

            for(String w : forward){
                char[] cur = w.toCharArray();
                for(int i=0; i<beginWord.length(); i++){
                    char original = cur[i];
                    for(char ch='a'; ch<='z'; ch++){
                        cur[i] = ch;
                        String newW = new String(cur);

                        if(backward.contains(newW)) return level + 1;

                        if(dict.contains(newW)){
                            next.add(newW);
                            dict.remove(newW);
                        }
                    }
                    cur[i] = original;
                }
            }

            forward = next;
            level++;
        }

        return 0;
    }
}
