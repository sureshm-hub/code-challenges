package proj.hobby.dsa.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> seen = new HashSet<>();

        ListNode tempA = headA, tempB = headB;

        while(tempA != null && tempB != null) {
            if(seen.contains(tempA)) {
                return tempA;
            }
            seen.add(tempA);
            if(seen.contains(tempB)) {
                return tempB;
            }
            seen.add(tempB);
            tempA = tempA.next;
            tempB = tempB.next;
        }

        while(tempA != null) {
            if(seen.contains(tempA)) {
                return tempA;
            }
            tempA = tempA.next;
        }

        while(tempB != null) {
            if(seen.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }

        return null;

    }

}
