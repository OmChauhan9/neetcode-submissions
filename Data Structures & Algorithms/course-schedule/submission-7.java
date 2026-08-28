class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[n];
        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            count++;

            for(int map : adj.get(top)){
                indegree[map]--;
                if(indegree[map] == 0) q.add(map);
            }
        }

        return count == n;
    }
}
