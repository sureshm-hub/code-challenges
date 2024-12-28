package proj.hobby.dsa.queue;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: PriorityQueue
 *
 * Complexity:
 *  Time: O(NlogN)
 *  Space: O(N)
 *
 */
public class RecentCounter {

    /**
     * Note: LinkedList will give O(1) Time complexity
     *
     */
    Queue<Integer> pings = new PriorityQueue<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        pings.add(t);
        while(pings.peek() < (t-3000) ) { //remove all pings outside the last 3000 millis
            pings.poll();
        }
        return pings.size();
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println("RecentCounter: "+rc.ping(1));
        System.out.println("RecentCounter: "+rc.ping(100));
        System.out.println("RecentCounter: "+rc.ping(3001));
        System.out.println("RecentCounter: "+rc.ping(3002));
    }
}
