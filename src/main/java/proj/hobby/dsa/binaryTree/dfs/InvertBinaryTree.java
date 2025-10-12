package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        return invert(root, new TreeNode(root.val));
    }

    private TreeNode invert(TreeNode orig, TreeNode invert) {

        if(orig == null) return null;

        if (orig.left  != null) invert.right = new TreeNode(orig.left.val);
        invert(orig.left, invert.right);

        if (orig.right != null) invert.left = new TreeNode(orig.right.val);
        invert(orig.right, invert.left);

        return invert;
    }
}
