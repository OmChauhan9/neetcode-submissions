class Twitter {

    HashMap<Integer, HashSet<Integer>> followMP;
    HashMap<Integer, List<int[]>> tweetMP;
    int cnt;

    public Twitter() {
        followMP = new HashMap<>();
        tweetMP = new HashMap<>();
        int cnt = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMP.containsKey(userId)){
            tweetMP.put(userId, new ArrayList<>());
        }
        tweetMP.get(userId).add(new int[]{cnt, tweetId});
        cnt++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        if(tweetMP.containsKey(userId)){
            pq.addAll(tweetMP.get(userId));
        }

        if(followMP.containsKey(userId)){
            for(int follow : followMP.get(userId)){
                if(follow == userId) continue;
                if(tweetMP.containsKey(follow)){
                    pq.addAll(tweetMP.get(follow));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(result.size() < 10 && !pq.isEmpty()){
            int top = pq.poll()[1];
            result.add(top);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMP.containsKey(followerId)){
            followMP.put(followerId, new HashSet<>());
        }
        followMP.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMP.get(followerId).remove(followeeId);
    }
}
