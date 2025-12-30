package proj.hobby.lld;

import java.util.*;

/**
 * https://leetcode.com/problems/lru-cache/description/
 *
 * LRUCache implementation backed by HashMap and LinkedList
 *
 * space: O(N) - N is the capacity
 *
 * time:
 *  put - O(N) for update head of dq + O(1) for lookup and put
 *  get - O(N) for update head of dq + O(1) for lookup
 *
 *
 */
public class LruCacheV2 {

    private int capacity;
    private Map<String, Integer> cache = new HashMap<>();
    private Deque<String> dq = new ArrayDeque<>();

    LruCacheV2(int capacity){
        this.capacity = capacity;
    }

    public Integer get(String key){
        if(cache.containsKey(key)) {
            Integer value = cache.get(key);
            updateHead(key);
            return value;
        }
        return -1;
    }

    public void put(String key, Integer value) {
        if(cache.size() == capacity && !cache.containsKey(key)) { // remove oldest entry
            String lruKey = dq.removeLast();
            cache.remove(lruKey);
        }
        cache.put(key, value);
        updateHead(key);
    }

    private void updateHead(String key){
        dq.remove(key);
        dq.offerFirst(key); // move the key to head
    }

    @Override
    public String toString() {
        return "[ capacity="+capacity+", cache="+cache+", dq="+dq+"]";
    }

    public static void main(String[] args) {
        LruCacheV2 lru = new LruCacheV2(2);
        lru.put("k1", null);
        lru.put("k2", 2);
        lru.get("k1");
        lru.put("k3",3);
        System.out.println("LRU = "+lru);
        System.out.println("k2 = "+lru.get("k2"));
        lru.put("k4",4);
        System.out.println("LRU = "+lru);
    }
}
