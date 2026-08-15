class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[n];
        for(int[] edge : prerequisites){
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int course = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            course++;

            for(int map : adj.get(top)){
                indegree[map]--;
                if(indegree[map] == 0) q.add(map);
            }
        }

        return course == n;
    }
}
