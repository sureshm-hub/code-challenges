package proj.hobby.dsa.linkedList;

/**
 * Definition for singly-linked list.
 *
 *
 */
 public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode temp = this;
        StringBuilder sb = new StringBuilder();
        while(temp != null) {
            sb.append(temp.val).append("--> ");
            temp = temp.next;
        }
        return sb.toString();
    }
}
