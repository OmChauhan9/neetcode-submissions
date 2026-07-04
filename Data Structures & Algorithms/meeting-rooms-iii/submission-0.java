class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        int[] lastAvail = new int[n];
        int[] roomUsed = new int[n];

        for(int i=0; i<m; i++){

            int start = meetings[i][0];
            int end = meetings[i][1];
            int duration = end - start;

            boolean found = false;

            int earlyRoom = 0;
            int earlyTime = Integer.MAX_VALUE;

            for(int room = 0; room<n; room++){

                if(lastAvail[room] <= start){
                    lastAvail[room] = end;
                    roomUsed[room]++;
                    found = true;
                    break;
                }

                if(lastAvail[room] < earlyTime){
                    earlyTime = lastAvail[room];
                    earlyRoom = room;
                }
            }

            if(!found){
                lastAvail[earlyRoom] += duration;
                roomUsed[earlyRoom]++;
            }
        }

        int maxUsed = 0;
        int result = -1;

        for(int i=0; i<n; i++){
            if(maxUsed < roomUsed[i]){
                maxUsed = roomUsed[i];
                result = i;
            }
        }

        return result;
    }
}