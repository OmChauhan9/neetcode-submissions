class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, HashSet<Character>> adjList = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.putIfAbsent(c, 0);
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i=0; i<n-1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLen = Math.min(word1.length(), word2.length());

            boolean mis = false;

            for(int j=0; j<minLen; j++){
                char u = word1.charAt(j);
                char v = word2.charAt(j);

                if(u != v){
                    if(adjList.get(u).add(v)){
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    mis = true;
                    break;
                }

                if(!mis && word1.length() > word2.length()){
                    return "";
                }
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char top = q.poll();
            sb.append(top);

            for(char c : adjList.get(top)){
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0){
                    q.add(c);
                }
            }
        }

        String str = sb.toString();
        
        return str.length() != adjList.size() ? "" : str;
    }
}
