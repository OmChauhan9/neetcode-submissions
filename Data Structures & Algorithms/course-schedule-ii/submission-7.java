class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            ans[index++] = top;

            for(int map : adj.get(top)){
                indegree[map]--;
                if(indegree[map] == 0){
                    q.add(map);
                }
            }
        }


        return index == numCourses ? ans : new int[]{};
    }
}
