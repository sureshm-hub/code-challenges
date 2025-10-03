package proj.hobby.dsa.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/reorder-list/description/?envType=problem-list-v2&envId=vorqfplg
 *
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        List<ListNode> nodes = new ArrayList<>();

        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

        for(int i = 0, j = nodes.size()-1; i <= j; i++, j--) {
            prev.next = nodes.get(i);
            if( i != j) {
                nodes.get(i).next = nodes.get(j);
            }
            prev = nodes.get(j);
            prev.next = null;
        }

    }
}
