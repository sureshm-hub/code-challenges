package proj.hobby.dsa.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * https://leetcode.com/problems/design-twitter/
 */
public class Twitter {

    private ConcurrentHashMap<Integer, List<int[]>> userFeed;
    private ConcurrentHashMap<Integer, Set<Integer>> followers; // follower -> followee
    private AtomicInteger orderId; // preserve tweet order

    public Twitter() {
        this.userFeed = new ConcurrentHashMap<>();
        this.followers = new ConcurrentHashMap<>();
        this.orderId = new AtomicInteger();
    }

    public void postTweet(int userId, int tweetId) {
        userFeed.computeIfAbsent(userId, x -> new ArrayList<>()).add(new int[]{orderId.incrementAndGet(), tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        int feedSize = 10;
        List<Integer> newsFeed = new ArrayList<>(feedSize);

        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        Comparator<int[]> c = Comparator.comparingInt(x -> x[0]);
        PriorityQueue<int[]> recents = new PriorityQueue<>(c.reversed()); //max heap

        // init
        for(Integer user : followees) {
            List<int[]> followeeFeed = userFeed.getOrDefault(user, new ArrayList<>());
            if(!followeeFeed.isEmpty()) {
                int last = followeeFeed.size() - 1;
                int[] feedIds = followeeFeed.get(last);
                recents.offer(new int[]{feedIds[0], feedIds[1], user, last});
            }
        }

        // hydrate user feed
        while(newsFeed.size() < feedSize && !recents.isEmpty()) {
            int[] feedItem = recents.poll();
            newsFeed.add(feedItem[1]);
            int next = --feedItem[3];
            int itemUserId = feedItem[2];
            List<int[]> followeeFeed = userFeed.getOrDefault(itemUserId, new ArrayList<>());
            if(next >= 0 && followeeFeed.size() > next) { // exhaust followee feed
                int[] feedIds = followeeFeed.get(next);
                recents.offer(new int[]{feedIds[0], feedIds[1], itemUserId, next});
            }
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId) followers.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
