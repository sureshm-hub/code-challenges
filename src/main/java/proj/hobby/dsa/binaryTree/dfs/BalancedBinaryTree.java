package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int height = heightBalanced(root);
        return height  != -1;
    }

    private int heightBalanced(TreeNode root) {
        if(root == null) return 0;

        int left = heightBalanced(root.left);
        int right = heightBalanced(root.right);

        if(left == -1 || right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return 1+Math.max(left, right);
    }
}
