package proj.hobby.dsa.linkedList;

import java.util.*;

public class MergeKLists2 {

    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {this.value = value;}
        ListNode(int value, ListNode next) {this.value = value; this.next = next;}
    }

    public ListNode mergeSortedLinkedLists(ListNode[] lists, int k) {
        if(lists == null || k == 0) {
            return null;// early exit
        }

        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a  -> a.value));

        // initialize PriorityQueue with the first k Nodes
        for(int i = 0; i < k; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode head = null, temp = null;
        while(!pq.isEmpty()) {

            ListNode next = pq.poll();
            ListNode candidate = next.next;
            if(candidate != null) {
                pq.offer(candidate);
            }

            if(head == null) {
                head = next;
            }

            if(temp != null) {
                temp.next = next;
            }
            temp = next;
        }

        return head;
    }

    public ListNode mergeLists(ListNode[] lists, int k) {
        // Input Validation
        if(lists ==  null || k == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for(int i = 0; i < k; i++) {
            if(lists[i] != null) { // validate for empty LinkedLists
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!heap.isEmpty()){
            ListNode temp = heap.poll();
            if(temp.next != null) {
                heap.offer(temp.next);
            }
            current.next = temp;
            current = temp;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        MergeKLists2 km2 = new MergeKLists2();
        ListNode head = km2.mergeLists(new ListNode[]{new ListNode(1, new ListNode(2, new ListNode(3))),
        new ListNode(1, new ListNode(3, new ListNode(5))),
        new ListNode(2, new ListNode(4, new ListNode(5,new ListNode(6, new ListNode(7, new ListNode(8))))))}, 3);
        ListNode curr = head;
        while(curr != null) {
            System.out.println(curr.value+ " -->");
            curr = curr.next;
        }
    }
}



