package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description
 */
public class NaryPreOrder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private void pre(Node root, List<Integer> res) {
        if(root == null) return;

        res.add(root.val);
        for(Node c : root.children) {
            pre(c, res);
        }
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
    };
}
