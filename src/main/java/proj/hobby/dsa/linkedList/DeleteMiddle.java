package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: fast, slow traversal
 *      V1: double Traversal
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class DeleteMiddle {

    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public ListNode deleteMiddleV1(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        int size = 0;
        ListNode temp = head;
        // find the size
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int mid = size/2;
        temp = head;
        for(int i = 0 ; i < mid -1 ; i++ ) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        DeleteMiddle ll = new DeleteMiddle();
        ListNode head = new ListNode(1);
        System.out.println(ll.deleteMiddle(head));

        head = new ListNode(1, new ListNode(2));
        System.out.println(ll.deleteMiddle(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(ll.deleteMiddle(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(ll.deleteMiddle(head));
    }

}
