package proj.hobby.dsa;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 */
public class SwapNodePairs {

    class ListNode {
        int val;
        ListNode next;
        public ListNode() {};
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) {   this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
             return head;
        }
        ListNode newHead = head.next;
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null && curr.next != null) {

            // manage pre and next nodes for next iteration
            if(prev != null) {
                prev.next  = curr.next;
            }
            prev = curr;
            ListNode next = curr.next.next;

            // swap nodes
            curr.next.next = curr;
            curr.next = null;

            // continue iteraion
            curr = next;
        }

        // handle last node
        if(curr != null) {
            prev.next = curr;
        }
        return newHead;
    }

}
