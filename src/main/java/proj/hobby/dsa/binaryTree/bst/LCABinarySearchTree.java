package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] parent = new TreeNode[1];
        if(p.val < q.val) {
            lca(root, p, q, parent);
        } else {
            lca(root, q, p, parent);
        }
        return parent[0];
    }

    private void lca(TreeNode node, TreeNode p, TreeNode q, TreeNode[] parent) {
        if(node.val < p.val) {
            lca(node.right, p, q, parent);
            return;
        } else if(node.val > q.val) {
            lca(node.left, p, q, parent);
            return;
        }
        parent[0] = node;
        return;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = new TreeNode[1];
        lca2(root, p, q, lca);
        return lca[0];
    }

    private int lca2(TreeNode root, TreeNode p, TreeNode q, TreeNode[] lca) {
        if (root == null || lca[0] != null) return 0;

        int left = lca2(root.left, p, q, lca);
        if(lca[0] != null)  return 2;

        int right = lca2(root.right, p, q, lca);
        if(lca[0] != null)  return 2;

        int self = (root == p || root == q) ? 1 : 0;
        int total = left + right + self;

        if(lca[0] == null && total >= 2) lca[0] = root;
        return total;
    }
}
