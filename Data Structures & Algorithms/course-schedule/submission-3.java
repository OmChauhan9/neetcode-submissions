class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            ls.add(top);

            for(int map : adj.get(top)){
                indegree[map]--;
                if(indegree[map] == 0){
                    q.add(map);
                }
            }
        }

        return ls.size() == numCourses ? true : false;
    }
}
