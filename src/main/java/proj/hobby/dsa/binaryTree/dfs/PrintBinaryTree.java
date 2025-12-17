package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/print-binary-tree
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int rows = height(root);
        int cols = (1 << rows) - 1;

        List<List<String>> tree = new ArrayList<>();

        List<String> row = new ArrayList<>(cols);
        for(int i = 0; i < cols; i++) row.add("");

        for(int i = 0; i < rows; i++) tree.add(new ArrayList<>(row));

        dfs(root, tree, 0, 0, cols, false);
        return tree;
    }

    private void dfs(TreeNode node, List<List<String>> tree, int row, int l, int r, boolean left) {
        if(node == null) return;

        int index = (l + r) / 2; // calc index in row

        tree.get(row).set(index, Integer.toString(node.val));

        dfs(node.left, tree, row + 1, l, index - 1, true);  // call left
        dfs(node.right, tree, row + 1, index + 1, r, false);// call right
    }

    private int height(TreeNode node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
