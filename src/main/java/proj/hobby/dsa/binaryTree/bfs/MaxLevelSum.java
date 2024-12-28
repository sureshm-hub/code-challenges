package proj.hobby.dsa.binaryTree.bfs;

import java.util.*;

import proj.hobby.dsa.binaryTree.TreeNode;
/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach:
 *
 * Complexity: BFS
 *  Time: O(N)
 *  Space: O(1) - maxSum, maxlevel, levelSum, level & levelQueue, temp
 *
 */
public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        int maxSum = Integer.MIN_VALUE, maxLevel = Integer.MAX_VALUE;//defaults to allow atleast root to reset
        Queue<TreeNode> levelQueue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        levelQueue.offer(root);
        int level = 1, levelSum = 0;
        while(!levelQueue.isEmpty()) {
            TreeNode current = levelQueue.poll();
            levelSum += current.val; // track levelSum

            // collect next level
            if(current.left != null) temp.offer(current.left);
            if(current.right != null) temp.offer(current.right);

            // we are at the end of the level
            if(levelQueue.isEmpty()) {
                if(levelSum > maxSum) { // we found a new maxSum
                    maxSum = levelSum;
                    maxLevel = level;
                }

                //reset levelQueue, temp and levelSum and increment level
                levelQueue = temp;
                temp = new LinkedList<>();
                level++;
                levelSum = 0;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        MaxLevelSum mls = new MaxLevelSum();
        System.out.println("Level with maximum sum: "+mls.maxLevelSum(TreeNode.fromArray(new Integer[]{1,7,0,7,-8,null,null})));
        System.out.println("Level with maximum sum: "+mls.maxLevelSum(TreeNode.fromArray(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127})));
    }
}
