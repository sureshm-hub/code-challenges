package proj.hobby.dsa.linkedList;

/**
 *
 * https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: pointer manipulation
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head, prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2));
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(rl.reverseList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        System.out.println(rl.reverseList(head));
    }
}
