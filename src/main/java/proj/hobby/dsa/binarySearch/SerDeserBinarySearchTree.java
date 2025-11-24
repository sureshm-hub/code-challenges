package proj.hobby.dsa.binarySearch;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst
 *
 */
public class SerDeserBinarySearchTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) return;

        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        final String[] vals = data.split(" ");
        Queue<Integer> q = new ArrayDeque<>();

        for(String val : vals) q.offer(Integer.parseInt(val));

        return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
    }

    private TreeNode deserialize(int min, int max, Queue<Integer> q) {
        if(q.isEmpty()) return null;

        int val = q.peek();
        if(val < min || val > max) return null;

        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(min, val, q);
        root.right = deserialize(val, max, q);
        return root;
    }

}
