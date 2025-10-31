package proj.hobby.dsa.linkedList;

import java.util.Random;

/**
 *
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class RandomNode {

    private final ListNode head;
    private final Random rand;

    private record T(Integer val, Integer size){}

    public RandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int index = rand.nextInt(Integer.MAX_VALUE);
        T t = getIndexVal(index);

        if(t.val() != null) return t.val();

        index %= t.size();
        t = getIndexVal(index);
        return t.val(); // case: index > size
    }

    private T getIndexVal(int index) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            if(size == index) return new T(temp.val, null); // case: index < size
            temp  = temp.next;
            size++;
        }
        return new T(null, size);
    }
}
