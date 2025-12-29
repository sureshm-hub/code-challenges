package proj.hobby.dsa.sort;

import proj.hobby.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/sort-list/description
 *
 */
public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        List<ListNode> nodes = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            nodes.add(temp);
            temp = temp.next;
        }

        Collections.sort(nodes, Comparator.comparingInt(o -> o.val));

        for(int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }
        nodes.get(nodes.size() - 1).next = null;

        return nodes.get(0);
    }

}
