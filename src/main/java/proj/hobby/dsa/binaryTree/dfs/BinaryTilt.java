package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/binary-tree-tilt/description
 */
public class BinaryTilt {

    private int tiltSum = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tiltSum;
    }

    private int sum(TreeNode node) {
        if(node == null) return 0;

        int l = sum(node.left);
        int r = sum(node.right);

        tiltSum += Math.abs(l - r);
        return node.val + l + r;
    }
}
