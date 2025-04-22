package proj.hobby.dsa.slidingWindow;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * problem:  Implement a rate limiter that restricts a user to a maximum of k requests within
 * a sliding window of t seconds. For example, if k = 5 and t = 60, a user can make at most 5
 * requests in any 60-second window. Return true if a request is allowed, false if it’s blocked.
 *
 * complexity:
 * time: O(N) - N is number of requests
 * space: O(K) - K is allowed requests
 *
 */
public class RateLimiter {

    boolean[] allowRequest(int k, int t, int[] requests) {

        if(requests == null) return null;// early exit

        // Dequeue remove old and add new request
        Deque<Integer> requestQueue = new ConcurrentLinkedDeque<>();// for concurrency, alternatively use new ArrayDeque<>() for simple scenarios
        boolean[] result = new boolean[requests.length];

        for(int i = 0; i < requests.length; i++) {
            requestQueue.add(requests[i]);
            if(requestQueue.size() <= k) {
                result[i] = true;
            } else {
                int tHead = requestQueue.peekFirst();
                if(requests[i]-tHead >= t) {
                    result[i] = true;
                    requestQueue.removeFirst();// cleanup oldest request
                } else {
                    result[i] = false;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter();
        boolean[] result = limiter.allowRequest(3, 10, new int[]{1, 2, 5, 9, 11, 15});
        System.out.println("Rate Limiter Result: "+Arrays.toString(result));
    }
}
