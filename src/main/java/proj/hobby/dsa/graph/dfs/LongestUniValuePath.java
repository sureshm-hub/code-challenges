package proj.hobby.dsa.graph.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/longest-univalue-path/description
 *
 */
public class LongestUniValuePath {

    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);

        int leftAndRoot = (node.left != null && node.left.val == node.val) ? l + 1 : 0;
        int rightAndRoot = (node.right != null && node.right.val == node.val) ? r + 1 : 0;

        max = Math.max(max, leftAndRoot + rightAndRoot);
        return Math.max(leftAndRoot, rightAndRoot);

    }
}
