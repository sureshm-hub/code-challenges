package proj.hobby.dsa.linkedList;

/**
 * https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: pointer manipulation
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class OddEven {

    public ListNode oddEvenList(ListNode head) {

        // for size  0, 1, 2 already in oddEven
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddCurrent = head, evenCurrent = head.next, evenFirst = evenCurrent, oddLast = oddCurrent;

        while(oddCurrent != null && evenCurrent!= null && evenCurrent.next != null) {

            ListNode oddNext = oddCurrent.next.next;
            ListNode evenNext = evenCurrent.next.next;

            oddCurrent.next = oddNext;
            evenCurrent.next = evenNext;

            oddCurrent = oddNext;
            evenCurrent = evenNext;

            oddLast = oddNext; // repoint to the last odd
        }

        oddLast.next = evenFirst;
        return head;
    }

    public static void main(String[] args) {
        OddEven oe = new OddEven();
        ListNode head = new ListNode(1);
        System.out.println(oe.oddEvenList(head));

        head = new ListNode(1, new ListNode(2));
        System.out.println(oe.oddEvenList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(oe.oddEvenList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(oe.oddEvenList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(oe.oddEvenList(head));

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(oe.oddEvenList(head));


        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        System.out.println(oe.oddEvenList(head));

    }
}
