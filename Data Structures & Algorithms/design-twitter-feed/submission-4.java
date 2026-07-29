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
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        if(tweetMP.containsKey(userId)){
            pq.addAll(tweetMP.get(userId));
        }

        if(followMP.containsKey(userId)){
            for(int follow : followMP.get(userId)){
                if(follow == userId) continue;
                pq.addAll(tweetMP.get(follow));
            }
        }

        while(ans.size() < 10 && !pq.isEmpty()){
            int[] top = pq.poll();
            ans.add(top[1]);
        }

        return ans;

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
