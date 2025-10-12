package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
