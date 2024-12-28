package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: DFS
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // if  root is null return 0
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right); // return 1 + max of left or right
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree md = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Maximum Depth Of Binary Tree"+md.maxDepth(root));
    }
}
