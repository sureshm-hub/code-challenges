package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/clone-graph
 *
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, Map<Integer, Node> visited) {
        if(node == null) return null;

        Node inst = new Node(node.val);
        visited.put(node.val, inst);
        for(Node n : node.neighbors) {
            if(!visited.containsKey(n.val)) {
                inst.neighbors.add(clone(n, visited));
            } else {
                inst.neighbors.add(visited.get(n.val));
            }
        }
        return inst;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
