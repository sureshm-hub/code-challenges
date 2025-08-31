package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k==0) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode curr=head;
        ListNode kEnd=null;
        int temp=k;
        while(curr.next != null) {
            curr = curr.next;
            if(kEnd != null) kEnd = kEnd.next;
            temp--;
            if(temp == 0) kEnd = head;
        }

        if(temp > 0) {

            int length = k-temp+1;
            //System.out.println(" temp, length >> "+temp+", "+length);
            temp = k%length;
            // System.out.println(" new temp >> "+temp);
            if(temp == 0) {
                return head;
            }
            curr=head;
            while(curr.next != null) {
                curr = curr.next;
                if(kEnd != null) kEnd = kEnd.next;
                temp--;
                if(temp == 0) kEnd = head;
            }
        }

        // System.out.println(" kEnd >> "+kEnd.val);

        ListNode tail = kEnd.next;
        kEnd.next = null;

        ListNode tailEnd = null;
        ListNode tailTemp = tail;
        while(tailTemp != null) {
            tailEnd = tailTemp;
            tailTemp = tailTemp.next;
        }

        ListNode currHead = dummy.next;
        dummy.next = tail;
        tailEnd.next = currHead;

        return dummy.next;
    }
}
