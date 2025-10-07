package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode cur = stack.pop();
        int val = cur.val;
        push(cur.right);
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void push(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
