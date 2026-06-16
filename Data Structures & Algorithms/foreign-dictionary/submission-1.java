class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        int[] indegree = new int[26];
        Set<Integer>[] adjList = new HashSet[26];
        for(int k=0; k<26; k++){
            adjList[k] = new HashSet<>();
        }
        boolean[] present = new boolean[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                present[c - 'a'] = true;
            }
        }

        int unique = 0;
        for(int z=0; z<26; z++){
            if(present[z]){
                unique++;
            }
        }

        for(int i=0; i<n-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int w1 = word1.length();
            int w2 = word2.length();
            int min = Math.min(w1,w2);
            boolean mis = false;
            for(int j=0; j<min; j++){
                char u = word1.charAt(j);
                char v = word2.charAt(j);
                if(u != v){
                    if(adjList[u - 'a'].add(v - 'a')){
                        indegree[v - 'a']++;
                    }
                    mis = true;
                    break;
                }
            }
            if(!mis && w2 < w1){
                return "";
            }
        }
        System.out.println("adjList ::: " + Arrays.toString(adjList));
        System.out.println("indegree ::: " + Arrays.toString(indegree));
        System.out.println("present ::: " + Arrays.toString(present));

        Queue<Integer> q = new ArrayDeque();
        for(int y=0; y<26; y++){
            if(indegree[y] == 0 && present[y] == true){
                q.add(y);
            }
        }
        System.out.println("Queue ::: " + q);

        StringBuilder str = new StringBuilder();
        while(!q.isEmpty()){
            int top = q.poll();
            str.append((char)('a' + top));
            for(int alien : adjList[top]){
                indegree[alien]--;
                if(indegree[alien] == 0){
                    q.add(alien);
                }
            }
        }

        String ans = str.toString();

        if(ans.length() != unique){
            return "";
        }
        return ans;
    }
}
