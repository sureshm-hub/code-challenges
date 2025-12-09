package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description
 *
 */
public class IsSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null) return root == subRoot;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;

        return p.val  == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
