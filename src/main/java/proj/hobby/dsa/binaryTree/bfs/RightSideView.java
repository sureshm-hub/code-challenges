package proj.hobby.dsa.binaryTree.bfs;

import java.util.*;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: BFS - Tree Traversal
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(H) - H is height of the tree
 *
 *
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if(root == null) {
            return rightView;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        Queue<TreeNode> temp = new LinkedList<>(); // for collecting next level nodes
        while(!levelQueue.isEmpty()) {
            TreeNode current = levelQueue.poll();
            if(current.left != null) temp.offer(current.left);
            if(current.right != null) temp.offer(current.right);

            // we are at the last element collect right side element, reset levelQueue & temp
            if(levelQueue.isEmpty()) {
                rightView.add(current.val);
                levelQueue = temp;
                temp = new LinkedList<>();
            }
        }
        return rightView;
    }

    public static void main(String[] args) {
        RightSideView rsv = new RightSideView();
        System.out.println("RightSideView: "+rsv.rightSideView(TreeNode.fromArray(new Integer[]{1,2,3,null,5,null,4})));
        System.out.println("RightSideView: "+rsv.rightSideView(TreeNode.fromArray(new Integer[]{1,2,3,4,null,null,null,5})));
        System.out.println("RightSideView: "+rsv.rightSideView(null));
    }
}
