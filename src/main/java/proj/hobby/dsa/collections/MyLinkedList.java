package proj.hobby.dsa.collections;

/**
 *
 * https://leetcode.com/problems/design-linked-list
 */
public class MyLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    int length = 0;
    ListNode dummy = new ListNode(0);

    public MyLinkedList() {
    }

    public int get(int index) {
        if(index < 0 || index >= length)
            return -1;

        ListNode cur = dummy.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode head = dummy.next;
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        dummy.next = newHead;
        ++length;
    }

    public void addAtTail(int val) {
        ListNode cur = dummy;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        ++length;
    }

    public void addAtIndex(int index, int val) {
        if(index > length) return;

        ListNode cur = dummy;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newCur = new ListNode(val);
        newCur.next = cur.next;
        cur.next = newCur;
        ++length;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;

        ListNode cur = dummy;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode temp = cur.next;
        cur.next = temp.next;
        length--;
    }
}
