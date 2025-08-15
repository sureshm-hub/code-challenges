package proj.hobby.dsa.linkedList;

public class MergeSortedLinkedLits {

    public ListNode mergeTwoListsV1(ListNode list1, ListNode list2) {

        // hanlde null ListNode
        if(list1 == null) return list2;
        if(list2 == null) return list1;


        ListNode head = null;
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode curr = head;
        while(curr != null) {
            if(list1 == null && list2 != null) {
                curr.next = list2;
                list2 = list2.next;
            } else if(list2 == null && list1 != null) {
                curr.next = list1;
                list1 = list1.next;
            } else if(list1 != null && list2 != null) {
                if(list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                } else {
                    curr.next = list2;
                    list2 = list2.next;
                }
            }
            curr =  curr.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) { // <= keeps stability
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null ? list1 : list2);
        return dummy.next;
    }

}
