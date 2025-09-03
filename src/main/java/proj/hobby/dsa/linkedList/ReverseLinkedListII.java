package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        ListNode beforeLeft = null;
        ListNode leftStart = null;
        ListNode curr = head;
        int i=1;

        while(curr != null) {

            if(i < left) {
                prev = curr;
                curr = curr.next;
            }
            if(i == left) {
                beforeLeft = prev;
                leftStart = beforeLeft.next;
                prev = null;
                beforeLeft.next = null;
            }

            if( left <= i && i <= right ) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if(i == right) {
                beforeLeft.next = prev;
                leftStart.next = curr;
                break;
            }
            i++;
        }

        return dummyHead.next;
    }

}
