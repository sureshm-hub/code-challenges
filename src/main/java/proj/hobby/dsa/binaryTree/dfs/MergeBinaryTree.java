package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/merge-two-binary-trees/description
 */
public class MergeBinaryTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode m = merge(root1, root2);
        return m;
    }

    private TreeNode merge(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return null;

        int n1Val = 0, n2Val = 0;
        TreeNode n1l = null, n1r = null, n2l = null, n2r = null;

        if(n1 != null) {
            n1Val = n1.val;
            n1l = n1.left;
            n1r = n1.right;
        }
        if(n2 != null) {
            n2Val = n2.val;
            n2l = n2.left;
            n2r = n2.right;
        }


        TreeNode l = merge(n1l, n2l);
        TreeNode r = merge(n1r, n2r);

        return new TreeNode(n1Val + n2Val, l, r);
    }
}
