package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description
 */
public class NaryPostOrder {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        post(root, result);
        return result;
    }

    private void post(Node root, List<Integer> result) {
        if(root == null) return;

        for(Node c : root.children) {
            post(c, result);
        }
        result.add(root.val);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
