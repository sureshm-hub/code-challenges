package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class BSTtoGreaterTree {

    private int prefix = 0; // prefix sum
    public TreeNode convertBST(TreeNode root) {
        reversedInOrder(root);
        return root;
    }

    private void reversedInOrder(TreeNode node) {
        if(node == null) return;

        reversedInOrder(node.right);
        prefix += node.val;
        node.val = prefix;
        reversedInOrder(node.left);
    }


}
