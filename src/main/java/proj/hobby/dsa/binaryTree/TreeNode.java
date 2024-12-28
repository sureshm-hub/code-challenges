package proj.hobby.dsa.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 *
 **/

public class TreeNode {

  // public accessor are convenience for binary tree packages,  but  not ideal
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }

  public static TreeNode fromArray(Integer[] nums) {
    if (nums == null || nums.length == 0) {
        return null;
    }

    TreeNode root = new TreeNode(nums[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1; // Start with the first child index
    while (!queue.isEmpty() && i < nums.length) {
        TreeNode current = queue.poll();

        // Process left child
        if (i < nums.length && nums[i] != null) {
            current.left = new TreeNode(nums[i]);
            queue.offer(current.left);
        }
        i++;

        // Process right child
        if (i < nums.length && nums[i] != null) {
            current.right = new TreeNode(nums[i]);
            queue.offer(current.right);
        }
        i++;
    }
    return root;
  }

  public TreeNode treeNodeOf(int val){
      return treeNodeOf(this, val);
  }

  private TreeNode treeNodeOf(TreeNode root, int val) {
      if(root == null){
          return null;
      }
      if (root.val == val) return root;

      TreeNode left = treeNodeOf(root.left, val);
      TreeNode right = treeNodeOf(root.right, val);
      return left != null ? left : right;
  }

}