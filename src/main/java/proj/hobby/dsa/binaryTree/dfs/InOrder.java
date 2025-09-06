package proj.hobby.dsa.binaryTree.dfs;

import java.util.*;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> path = new ArrayList<>();
        inOrder(root, path);
        return path;
    }

    private void inOrder(TreeNode root, List<Integer> path) {
        if(root == null) {
            return;
        }
        inOrder(root.left, path);
        path.add(root.val);
        inOrder(root.right, path);
    }

}
