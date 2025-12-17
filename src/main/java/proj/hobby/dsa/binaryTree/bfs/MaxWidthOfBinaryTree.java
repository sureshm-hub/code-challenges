package proj.hobby.dsa.binaryTree.bfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description
 *
 */
public class MaxWidthOfBinaryTree {

    class NodePos {
        TreeNode node;
        long idx;
        NodePos(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<NodePos> q = new ArrayDeque<>();
        q.offer(new NodePos(root, 0));

        long max = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            long start = q.peek().idx;

            long first = 0, last = 0;

            for(int i = 0; i < size; i++) {
                NodePos np = q.poll();
                long norm = np.idx - start; //normalize indices at each level to balance out any missing parents

                if(i == 0) first = norm;
                if(i == size - 1) last = norm;

                if(np.node.left != null) q.offer(new NodePos(np.node.left, 2 * norm)) ;
                if(np.node.right != null) q.offer(new NodePos(np.node.right, 2 * norm + 1));
            }

            max = Math.max(max, last - first + 1);
        }

        return (int) max;
    }
}
