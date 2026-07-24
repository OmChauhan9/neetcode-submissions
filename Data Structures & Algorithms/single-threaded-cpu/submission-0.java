class Solution {
    public int[] getOrder(int[][] tasks) {

        int[][] preserveIndex = new int[tasks.length][3];
        for(int i=0; i<tasks.length; i++){
            preserveIndex[i][0] = tasks[i][0];
            preserveIndex[i][1] = tasks[i][1];
            preserveIndex[i][2] = i;
        }

        Arrays.sort(preserveIndex, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int[] res = new int[tasks.length];
        int index = 0;
        int cur_time = 0;
        int ansIndex = 0;

        while(index < tasks.length || !pq.isEmpty()){

            if(pq.isEmpty() && cur_time <= preserveIndex[index][0]){
                cur_time = preserveIndex[index][0];
            }

            while(index < tasks.length && preserveIndex[index][0] <= cur_time){
                pq.add(new int[]{preserveIndex[index][1], preserveIndex[index][2]});
                index++;
            }

            int[] cur_task = pq.poll();
            cur_time += cur_task[0];
            res[ansIndex++] = cur_task[1];
        }

        return res;
    }
}