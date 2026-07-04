class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> roomUsed = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Primary: Sort by end time
            }
            return Integer.compare(a[1], b[1]); // Secondary tie-breaker: Sort by room number
        });

        PriorityQueue<Integer> availRoom = new PriorityQueue<>();

        int[] roomCnt = new int[n];

        for(int rooms=0; rooms<n; rooms++){
            availRoom.add(rooms);
        }

        for(int i=0; i<m; i++){

            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end - start;

            while(!roomUsed.isEmpty() && roomUsed.peek()[0] <= start){
                int availableRoom = roomUsed.peek()[1];
                roomUsed.poll();
                availRoom.add(availableRoom);
            }

            if(!availRoom.isEmpty()){
                int availableRoom = availRoom.peek();
                availRoom.poll();
                roomUsed.add(new int[]{end, availableRoom});
                roomCnt[availableRoom]++;
            }else{
                int availableRoom = roomUsed.peek()[1];
                int endTime = roomUsed.peek()[0];
                roomUsed.poll();
                roomUsed.add(new int[]{endTime + duration, availableRoom});
                roomCnt[availableRoom]++;
            }
        }

        int maxUsed = 0;
        int result = -1;

        for(int i=0; i<n; i++){
            if(maxUsed < roomCnt[i]){
                maxUsed = roomCnt[i];
                result = i;
            }
        }

        return result;
    }
}