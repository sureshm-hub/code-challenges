package proj.hobby.dsa.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/add-two-numbers-ii
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        while(l1 != null) {
            num1.add(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            num2.add(l2.val);
            l2 =  l2.next;
        }

        List<Integer> result = new ArrayList<>();
        int i = num1.size() - 1;
        int j = num2.size() - 1;

        int carry = 0;
        while(i >= 0 || j >= 0) {
            int d1 = i >= 0 ? num1.get(i) : 0;
            int d2 = j >= 0 ? num2.get(j) : 0;

            int sum = d1 + d2 + carry;
            result.add(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        if(carry > 0)  result.add(carry);

        int k = result.size() - 1;
        ListNode first = new ListNode();
        ListNode temp = first;
        while(k >= 0) {
            temp.next = new ListNode(result.get(k));
            temp = temp.next;
            k--;
        }

        return first.next;
    }
}
