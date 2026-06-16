class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
        }
        System.out.println("Adj ::: " + adj);

        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it : adj.get(i)){
                indegree[it] += 1;
            }
        }
        System.out.println("indegree ::: " + Arrays.toString(indegree));

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        System.out.println("Queue ::: " + q);


        // List<Integer> ls = new ArrayList<>();
        int[] ans = new int[numCourses];
        int ind = 0;
        while(!q.isEmpty()){
            int n = q.peek();
            q.poll();
            ans[ind++] = n;
            for(int it : adj.get(n)){
                indegree[it] -= 1;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
            
        }
        System.out.println("indegree ::: " + Arrays.toString(indegree));
        System.out.println("Queue ::: " + q);
        System.out.println("ans ::: " + Arrays.toString(ans));
        // System.out.println("ls :: " + ls);

        if(ind == numCourses){
            return ans;
        }

        return new int[] {};
    }
}
