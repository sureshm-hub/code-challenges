package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                int dup = curr.val;
                while (curr != null && curr.val == dup) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;

    }
}
