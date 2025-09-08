package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 */
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        traverse(node.right);
        flattenNode(node);
    }

    private void flattenNode(TreeNode node) {
        if (node == null || node.left == null) return;
        if (node.left != null && node.right == null) {
            node.right = node.left;
            node.left = null;
            return;
        }

        TreeNode temp = node.right;
        TreeNode curr = node.left;
        node.right = node.left;
        node.left = null;

        while(curr.right != null) curr = curr.right;
        curr.right = temp;
    }
}
