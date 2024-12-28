package proj.hobby.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNFromHeadTest {

    @Test
    public void test(){
        RemoveNFromHead rn = new RemoveNFromHead();
        RemoveNFromHead.ListNode n1 = rn.new ListNode(1);
        RemoveNFromHead.ListNode n2 = rn.new ListNode(2, n1);
        RemoveNFromHead.ListNode n3 = rn.new ListNode(3, n2);
        RemoveNFromHead.ListNode n4 = rn.new ListNode(4, n3);
        RemoveNFromHead.ListNode n5 = rn.new ListNode(5, n4);
        RemoveNFromHead.ListNode head = rn.new ListNode(6, n5);
        System.out.print("Starting: ");
        print(head);
        head = rn.removeNthFromEnd(head, 5);
        System.out.print("Removing 5th from End: ");
        print(head);
        assertEquals(4, head.next.val);
        System.out.print("Removing 5th from End: ");
        head = rn.removeNthFromEnd(head, 5);
        print(head);
        assertEquals(4, head.val);

        System.out.print("Removing 10th from End: ");
        head = rn.removeNthFromEnd(head, 10);
        print(head);
        assertEquals(4, head.val);

        System.out.print("Removing 0th from End: ");
        head = rn.removeNthFromEnd(head, 10);
        print(head);
        assertEquals(4, head.val);

        System.out.print("Removing 1st from End: ");
        head = rn.removeNthFromEnd(head, 1);
        print(head);
        assertEquals(2, head.next.next.val);
    }

    private static RemoveNFromHead.ListNode print(RemoveNFromHead.ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null){
                System.out.print(", ");
            } else {
                System.out.println();
            }
            head = head.next;
        }
        return head;
    }
}