package proj.hobby.dsa;

/**
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 */
public class RemoveNFromHead {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode removeNthFromEndSinglePass(ListNode head, int n) {
        if(n == 0 || head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode nPrev = null;
        while(curr  != null) {
            if(nPrev == null) {
                if(n == 0 ) {
                    nPrev = head;
                } else {
                    n--;
                }
            } else {
                nPrev = nPrev.next;
            }
            curr = curr.next;
        }
        if(n == 0 && nPrev == null) {
            head = head.next;
        } else if(nPrev != null && nPrev.next != null) {
            nPrev.next = nPrev.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0 ; i <= n ; i++) {
            if(fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
