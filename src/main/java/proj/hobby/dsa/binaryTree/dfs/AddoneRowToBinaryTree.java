package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/add-one-row-to-tree
 *
 */
public class AddoneRowToBinaryTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        addRow(root, val, depth, 1, null, null);
        return root;
    }

    private TreeNode addRow(TreeNode node, int val, int depth, int cur, TreeNode l, TreeNode r) {
        if(node == null && cur != depth) return null;

        if(cur < depth -1) {
            addRow(node.left, val, depth, cur + 1, null, null);
            addRow(node.right, val, depth, cur + 1, null, null);
            return null;
        } else if(cur == depth - 1) {
            node.left = addRow(node.left, val, depth, cur + 1, node.left, null);
            node.right = addRow(node.left, val, depth, cur + 1, null, node.right);
            return null;
        } else if(cur == depth) {
            return new TreeNode(val, l, r);
        }
        return null;
    }
}
