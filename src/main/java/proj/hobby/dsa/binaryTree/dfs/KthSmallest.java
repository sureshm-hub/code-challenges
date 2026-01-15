package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallest {

    private int kthSmall = 0;

    public int kthSmallest(TreeNode root, int k) {
        findKthSmall(root, k, 0);
        return kthSmall;
    }

    private int findKthSmall(TreeNode node, int k, int count) {
        if(node == null) return count;
        int left = findKthSmall(node.left, k, count);
        if(left + 1 == k) {
            kthSmall = node.val;
        }
        int right = findKthSmall(node.right, k, left + 1);
        return right;
    }

    public int kthSmallest2(TreeNode root, int k) {

        List<Integer> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        count.add(0);
        kSmall(root, k, count, result);
        return result.get(0);
    }

    private void kSmall(TreeNode root, int k, List<Integer> count, List<Integer> result) {

        if(root == null || !result.isEmpty()) return;

        kSmall(root.left, k, count, result);

        int cur = count.get(0) + 1;
        if(cur == k) result.add(root.val);
        count.set(0, cur);

        kSmall(root.right, k, count, result);
    }
}
