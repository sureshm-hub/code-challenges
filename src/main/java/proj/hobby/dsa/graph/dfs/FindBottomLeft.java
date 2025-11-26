package proj.hobby.dsa.graph.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value
 */
public class FindBottomLeft {

    public int findBottomLeftValue(TreeNode root) {

        int[] levelLeft = new int[]{1, root.val};// level, leftVal
        findBottomLeft(root, 1, levelLeft);
        return levelLeft[1];
    }

    private void findBottomLeft(TreeNode node, int level, int[] levelLeft) {
        if(node == null) return;

        if(levelLeft[0] < level) {
            levelLeft[0] = level;
            levelLeft[1] = node.val;
        }

        findBottomLeft(node.left, level + 1, levelLeft);
        findBottomLeft(node.right, level + 1, levelLeft);
    }
}
