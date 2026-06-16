class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
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

        int[] vis = new int[numCourses];
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            vis[q.peek()] = 1;

            for(int it : adj.get(q.peek())){
                indegree[it] -= 1;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
            ls.add(q.poll());
        }
        System.out.println("indegree ::: " + Arrays.toString(indegree));
        System.out.println("Queue ::: " + q);
        System.out.println("ls :: " + ls);

        if(ls.size() == numCourses){
            return true;
        }
        return false;
    }
}
