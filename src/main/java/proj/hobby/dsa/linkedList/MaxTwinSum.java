package proj.hobby.dsa.linkedList;

/**
 * Approach: fast & slow pointer to find mid
 *           Make 2 lists and reverse the second
 *           traverse first and second lists to calculate max pairwise
 *           reverse again the second list and link to first half
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 *
 */
public class MaxTwinSum {

    public int pairSum(ListNode head) {

        int maxPairSum = Integer.MIN_VALUE;
        ListNode slow = head, fast = head, prev = null;

        //find mid
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // make 2 linked lists and reverse the second one
        prev.next = null;
        ListNode reversed = reverse(slow);

        ListNode currentFirst = head, currentSecond = reversed;

        // find max Twin Pair
        while(currentFirst != null && currentSecond != null) {
            maxPairSum = Math.max(maxPairSum, currentFirst.val + currentSecond.val);
            currentFirst = currentFirst.next;
            currentSecond = currentSecond.next;
        }

        //form the original linked list
        prev.next = reverse(reversed);

        return maxPairSum;
    }

    private ListNode reverse(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, current = head;

        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }


    public static void main(String[] args) {
        MaxTwinSum mts = new MaxTwinSum();

        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(mts.pairSum(head));

        head = new ListNode(1, new ListNode(2, new ListNode(30, new ListNode(4))));
        System.out.println(mts.pairSum(head));

        head = new ListNode(10, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(mts.pairSum(head));

    }
}
