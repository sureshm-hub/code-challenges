package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 */
public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 && right == 0) {
            return 1;
        } else if (left != 0 && right == 0) {
            return 1 + left;
        } else if (left == 0 && right != 0) {
            return 1 + right;
        }
        return 1 + Math.min(left, right);
    }
}
