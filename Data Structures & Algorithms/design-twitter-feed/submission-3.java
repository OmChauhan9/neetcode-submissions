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

        if(tweetMP.containsKey(userId)){
            pq.addAll(tweetMP.get(userId));
        }

        if(followMP.containsKey(userId)){
            for(int following : followMP.get(userId)){
                if(following == userId) continue;
                if(tweetMP.containsKey(following)){
                    pq.addAll(tweetMP.get(following));
                }
            }
        }
        // HashSet<Integer> followees = followMP.getOrDefault(userId, new HashSet<>());

        // for (int followeeId : followees) {
        //     List<int[]> tweets = tweetMP.get(followeeId);
        //     if (tweets != null) {
        //         pq.addAll(tweets);
        //     }
        // }

        // // Only add the user's own tweets if they aren't already in the followees set
        // if (!followees.contains(userId)) {
        //     List<int[]> userTweets = tweetMP.get(userId);
        //     if (userTweets != null) {
        //         pq.addAll(userTweets);
        //     }
        // }

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
