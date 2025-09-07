package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        int val = targetSum - root.val;
        if(val == 0 && root.left == null  && root.right == null ) return true;
        return hasPathSum( root.left, val ) || hasPathSum( root.right, val);

    }

}
