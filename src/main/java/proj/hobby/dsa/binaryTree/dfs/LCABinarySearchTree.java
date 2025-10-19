package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = new TreeNode[1];
        lca(root, p, q, lca);
        return lca[0];
    }

    private int lca(TreeNode root, TreeNode p, TreeNode q, TreeNode[] lca) {
        if (root == null || lca[0] != null) return 0;

        int left = lca(root.left, p, q, lca);
        if(lca[0] != null)  return 2;

        int right = lca(root.right, p, q, lca);
        if(lca[0] != null)  return 2;

        int self = (root == p || root == q) ? 1 : 0;
        int total = left + right + self;

        if(lca[0] == null && total >= 2) lca[0] = root;
        return total;
    }
}
