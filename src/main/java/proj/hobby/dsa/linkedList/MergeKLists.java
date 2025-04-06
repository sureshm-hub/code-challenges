package proj.hobby.dsa.linkedList;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * Merge K Sorted LinkedLists
 *
 * Complexity:
 *  Time: O(NlogK) - N is total number of elements and K is number of Lists
 *  Space: O(N) + O(K) - N - total number of elements & K - for Heap
 *
 * EdgeCases:
 *  handle multiple lists having same val
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val)); // min Heap

        for(int i =0 ; i < lists.length; i++) {
            if(lists[i] != null)  {
                heap.offer(lists[i]);
            }
        }
        ListNode head = null;
        ListNode prev = null;
        while(!heap.isEmpty()) {

            ListNode min  = heap.poll();
            ListNode curr = new ListNode(min.val);
            if(head == null) {
                head = curr; // track head
            }
            if(prev != null) {
                prev.next = curr;// track next
            }
            prev = curr;

            ListNode nextNode = min.next;
            if(nextNode != null){
                heap.offer(nextNode);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        MergeKLists kMerge = new MergeKLists();
        ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        ListNode head = kMerge.mergeKLists(lists);
        System.out.println(head.toString());

        lists = new ListNode[]{};
        head = kMerge.mergeKLists(lists);
        System.out.println(head == null ? null : head.toString());

        head1 = null;
        head2 = new ListNode(-2);
        head3 = new ListNode(-3, new ListNode(-2, new ListNode(1)));
        lists = new ListNode[]{head1, head2, head3};
        head = kMerge.mergeKLists(lists);
        System.out.println(head == null ? null : head.toString());

        head1 = new ListNode(-1, new ListNode(1));
        head2 = new ListNode(-3, new ListNode(1, new ListNode(4)));
        head3 = new ListNode(-2, new ListNode(-1, new ListNode(0, new ListNode(2))));
        lists = new ListNode[]{head1, head2, head3};
        head = kMerge.mergeKLists(lists);
        System.out.println(head == null ? null : head.toString());
    }
}
