package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == prev.val) {
                int dupVal = curr.val;
                while(curr != null && curr.val == dupVal) {
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
