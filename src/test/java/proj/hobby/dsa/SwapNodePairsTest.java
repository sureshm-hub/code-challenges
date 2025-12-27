package proj.hobby.dsa;

import org.junit.jupiter.api.Test;
import proj.hobby.dsa.linkedList.SwapNodePairs;

class SwapNodePairsTest {

    @Test
    void swapPairs() {
        SwapNodePairs swap = new SwapNodePairs();
        SwapNodePairs.ListNode head = swap.new ListNode(1);
        SwapNodePairs.ListNode temp = head;
        for(int i =2; i  <=5; i++) {
            temp.next = swap.new ListNode(i);;
            temp = temp.next;
        }
        print(head);
        head = swap.swapPairs(head);
        print(head);
    }

    private void print(SwapNodePairs.ListNode head){
        while(head != null){
            String sep = head.next == null ? "\n": " ->";
            System.out.print(head.val+sep);
            head = head.next;
        }
    }
}