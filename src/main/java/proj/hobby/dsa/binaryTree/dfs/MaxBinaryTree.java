package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/maximum-binary-tree/description
 *
 */
public class MaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if(l > r) return null;

        int max = l;
        for(int i = l ; i <= r; i++) {
            if(nums[max] < nums[i]) max = i;
        }

        TreeNode node = new TreeNode(nums[max], buildTree(nums, l, max - 1), buildTree(nums, max+1, r));
        return node;
    }
}
