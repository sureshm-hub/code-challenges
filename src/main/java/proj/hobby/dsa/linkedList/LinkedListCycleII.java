package proj.hobby.dsa.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;


        // Option 2: Using HashSet
        //        ListNode cur = head;
        //        Set<ListNode> nextSet = new HashSet<>();
        //        nextSet.add(cur);
        //        while(cur != null && cur.next != null) {
        //            if(!nextSet.add(cur.next)) return cur.next;
        //            cur = cur.next;
        //        }
        //        return null;
    }

}
