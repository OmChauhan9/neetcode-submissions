class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int[] ans = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            ans[idx++] = top;

            for(int map : adj.get(top)){
                indegree[map]--;
                if(indegree[map] == 0) q.add(map);
            }
        }

        return idx == n ? ans : new int[]{};        
    }
}
