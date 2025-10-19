package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {

        ListNode next = node.next;

        while (next != null) {
            node.val = next.val;

            ListNode prev = node;
            node = next;
            next = next.next;
            if(next == null) {
                prev.next = null;
            }
        }

    }
}
