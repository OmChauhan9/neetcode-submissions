class Twitter {
    HashMap<Integer, HashSet<Integer>> followMP;
    HashMap<Integer, List<int[]>> tweetMP;
    int count;

    public Twitter() {
        followMP = new HashMap<>();
        tweetMP = new HashMap<>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMP.containsKey(userId)){
            tweetMP.put(userId, new ArrayList<>());
        }
        tweetMP.get(userId).add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> getFeed = new ArrayList<>();

        HashSet<Integer> followees = new HashSet<>();
        followees.add(userId);

        HashSet<Integer> allfollowees = followMP.get(userId);
        if (allfollowees != null) {
            followees.addAll(allfollowees);
        }

        for(int foll : followees){
            List<int[]> tweetsIDS = tweetMP.get(foll);
            if(tweetsIDS != null){
                pq.addAll(tweetsIDS);
            }
        }

        while(getFeed.size() < 10 && pq.size() > 0){
            int recent = pq.poll()[1];
            getFeed.add(recent);
        }

        return getFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMP.containsKey(followerId)){
            followMP.put(followerId, new HashSet<>());
        }
        followMP.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMP.containsKey(followerId)){
            followMP.get(followerId).remove(followeeId);
        }
    }
}
