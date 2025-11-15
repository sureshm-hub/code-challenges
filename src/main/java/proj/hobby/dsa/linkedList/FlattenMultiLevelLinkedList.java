package proj.hobby.dsa.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultiLevelLinkedList {

    public Node flatten(Node head) {
        Deque<Node> stack = new ArrayDeque<>();
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            if(temp.child != null) {
                if(temp.next != null) stack.push(temp.next);
                temp.next = temp.child;
                temp.child = null;
                temp.next.prev = temp;
            }
            Node cur = temp;
            temp = temp.next;
            if(temp == null) {
                while(temp == null && !stack.isEmpty())  temp = stack.pop();
                if(temp != null) {
                    cur.next = temp;
                    temp.prev = cur;
                }
            }
        }
        return head;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
