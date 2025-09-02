package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionLists {

    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0), before = beforeDummy;
        ListNode afterDummy = new ListNode(0), after = afterDummy;

        ListNode curr = head;
        while(curr != null) {
            if(curr.val < x) {
                before.next = curr;
                before = curr;
            } else {
                after.next = curr;
                after = curr;
            }
            curr = curr.next;
        }
        after.next = null;
        before.next = afterDummy.next;

        return beforeDummy.next;
    }
}
