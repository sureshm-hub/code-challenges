package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;
/**
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root, false);
    }

    private int sumLeft(TreeNode node, boolean left) {

        if(node == null) return 0;

        if (node.left == null && node.right == null && left) return node.val;

        int lSum = sumLeft(node.left, true);
        int rSum = sumLeft(node.right, false);

        return lSum + rSum;
    }
}
