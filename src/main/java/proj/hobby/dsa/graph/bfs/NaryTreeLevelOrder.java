package proj.hobby.dsa.graph.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 */
public class NaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        List<Node> levels = new ArrayList<>();
        if(root != null) levels.add(root);
        int start = 0;
        int end = levels.size();

        while(start < end) {
            List<Integer> curr = new ArrayList<>();
            for(int i = start; i < end; i++) {
                Node next = levels.get(i);
                curr.add(next.val);
                if(next.children != null){
                    for(Node c : next.children) levels.add(c);
                }
            }
            res.add(curr);
            start = end;
            end = levels.size();
        }

        return res;
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
