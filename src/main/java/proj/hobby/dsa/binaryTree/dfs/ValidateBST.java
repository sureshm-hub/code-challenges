package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return validateBST(root,null, null);
    }

    private boolean validateBST(TreeNode node, Long min, Long max) {
        if(node == null) return true;

        long v = node.val;
        if(min != null && v <= min) return false;
        if(max != null && v >= max) return false;
        return validateBST(node.left, min, v) && validateBST(node.right, v, max);
    }
}
