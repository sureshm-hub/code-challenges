package proj.hobby.dsa.sort;

import proj.hobby.dsa.linkedList.ListNode;

/**
 *
 * https://leetcode.com/problems/insertion-sort-list/
 *
 */
public class InsertionSort {

    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        ListNode cur  = head;

        while(cur != null) {
            ListNode next = cur.next;

            ListNode pre = dummy;
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;

            cur = next;
        }

        return dummy.next;
    }
}