package proj.hobby.dsa.binaryTree.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 */
public class NextRightII {

    public Node connect(Node root) {
        connect(root, new HashMap<>(), 0);
        return root;
    }

    private void connect(Node node, Map<Integer, Node> map, int level) {
        if (node == null) return;

        connect(node.left, map, level + 1);
        connect(node.right, map, level + 1);

        if (node.left != null && node.right != null) {
            if (map.get(level) != null) {
                map.get(level).next = node.left;
            }
            node.left.next = node.right;
            map.put(level, node.right);
        }

        if (node.left != null && node.right == null) {
            if (map.get(level) != null) {
                map.get(level).next = node.left;
            }
            map.put(level, node.left);
        }

        if (node.right != null && node.left == null) {
            if (map.get(level) != null) {
                map.get(level).next = node.right;
            }
            map.put(level, node.right);
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}


