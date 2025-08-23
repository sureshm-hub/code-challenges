package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while( l1 != null && l2 != null) {
            int sum = carry+l1.val+l2.val;
            curr.next = new ListNode(sum%10);
            carry =  sum/10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp = l1 != null ? l1 : l2;
        while(carry > 0 && temp != null) {
            int sum = carry+ temp.val;
            curr.next = new ListNode(sum%10);
            carry = sum/10;
            curr = curr.next;
            temp = temp.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        curr.next = temp;
        return dummy.next;
    }

}
