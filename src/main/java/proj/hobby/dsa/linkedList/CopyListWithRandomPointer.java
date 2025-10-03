package proj.hobby.dsa.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if(head == null) return head;

        Map<Node, Node> randMap = new HashMap<>();
        Node temp = head;

        Node dummyHead = new Node(-1);
        Node clone = dummyHead;

        while(temp != null) {
            Node newTemp = new Node(temp.val);
            clone.next = newTemp;

            randMap.put(temp, newTemp);

            temp = temp.next;
            clone = clone.next;
        }

        clone = dummyHead.next;
        temp = head;

        while(temp != null) {
            clone.random = randMap.get(temp.random);

            clone = clone.next;
            temp = temp.next;
        }

        return dummyHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
