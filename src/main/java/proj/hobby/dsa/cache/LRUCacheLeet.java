package proj.hobby.dsa.cache;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * LRUCache implementation backed by HashMap and Node
 *
 * space: O(N) - N is the capacity
 *
 * time for ArrayDeque
 *  put - O(N) for update head of dq (uses remove) + O(1) for lookup and put
 *  get - O(N) for update head of dq (uses remove) + O(1) for lookup
 *
 * time for Node
 * put - O(1)
 * get- O(1)
 *
 */
public class LRUCacheLeet {

    class Node{
        Integer key;
        Integer value;
        Node prev, next;
        Node(Integer k, Integer v){key =k; value = v;}

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

    private int capacity;
    private Map<Integer, Node> cache = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0, 0);

    public LRUCacheLeet(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;

        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity ) { // remove oldest entry
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    @Override
    public String toString() {
        return "[ capacity="+cache.size()+", cache="+cache+", nodeString="+nodeString()+"]";
    }

    private String nodeString(){
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while(temp != null){
            sb.append(temp.value).append(" -->");
            temp = temp.next;
        }
        sb.append("|");
        temp = tail;
        while(temp != null) {
            sb.append(temp.value).append("<--");
            temp = temp.prev;
        }
        sb.append("|");
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCacheLeet lru = new LRUCacheLeet(2);
        System.out.println("k99 = "+lru.get(99));
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println("LRU = "+lru);
        lru.get(1);
        lru.put(3,3);
        System.out.println("LRU = "+lru);
        System.out.println("k2 = "+lru.get(2));
        lru.put(4,4);
        System.out.println("LRU = "+lru);
        lru.put(4,41);
        System.out.println("LRU = "+lru);
    }
}
