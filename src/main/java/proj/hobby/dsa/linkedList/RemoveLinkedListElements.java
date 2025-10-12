package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/remove-linked-list-elements
 *
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

}