package proj.hobby.dsa.binaryTree.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class NextRight {

    public Node connect(Node root) {
        traverse(root, new HashMap<>(), 0);
        return root;
    }

    private void traverse(Node node, Map<Integer, Node> map, int level) {
        if (node == null) return;
        traverse(node.left, map, level + 1);
        traverse(node.right, map, level + 1);
        if (node.left != null) {
            node.left.next = node.right;
            node.right.next = null;
            if(map.get(level) == null) {
                map.put(level, node.right);
            } else {
                map.get(level).next = node.left;
                map.put(level, node.right);
            }
        }
    }

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


