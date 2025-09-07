package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;
import proj.hobby.dsa.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class SortedList2BST {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }
        TreeNode root = buildTree(0, vals.size() - 1, vals);
        return root;
    }

    private TreeNode buildTree(int start, int end, List<Integer> vals) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = buildTree(start, mid - 1, vals);
        node.right = buildTree(mid + 1, end, vals);
        return node;
    }

}
