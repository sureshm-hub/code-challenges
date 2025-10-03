package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/linked-list-cycle/
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
