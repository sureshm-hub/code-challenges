package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        max = Math.max(max, l + r);
        return 1 + Math.max(l, r);
    }
}
