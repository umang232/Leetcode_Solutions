class Twitter {
    int count;
    HashMap<Integer,List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        if(tweetMap.containsKey(userId)){
            for(int [] tweet : tweetMap.get(userId)){
                maxHeap.offer(tweet);
            }
        }
        if(followMap.containsKey(userId)){
            for(int followeeId : followMap.get(userId)){
                if(tweetMap.containsKey(followeeId)){
                    for(int [] tweet : tweetMap.get(followeeId)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int temp = 0;
        while(!maxHeap.isEmpty() && temp < 10){
            result.add(maxHeap.poll()[1]);
            temp++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */