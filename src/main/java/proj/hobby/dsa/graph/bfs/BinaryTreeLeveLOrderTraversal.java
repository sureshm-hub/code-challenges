package proj.hobby.dsa.graph.bfs;

import java.util.*;
/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 */
public class BinaryTreeLeveLOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> level = new ArrayList<>();
        if(root == null) {
            return level;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() > 0) {
            List<Integer> vals = new ArrayList<>();
            level.add(vals);
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode current = queue.poll();
                vals.add(current.val);
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return level;
    }
}


/**
 * Definition for a binary tree node.
 *
 * */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
