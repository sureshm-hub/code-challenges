package proj.hobby.dsa.binaryTree.dfs;

import java.util.*;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach:  DFS with levelSum to track the sum from parent levels to node
 *
 * Complexity:
 *  Time: O(H * N) - check at each node if there is a target sum which is O(H)
 *  Space: O(H) - H is height of tree
 *
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        List<Long> levelSumList = new LinkedList<>();
        return pathSum(root, targetSum, levelSumList);
    }

    private int pathSum(TreeNode root, int targetSum, List<Long> levelSum) {
        if(root == null)  return 0;

        int count = 0;
        for(int level = 0; level < levelSum.size(); level++) {
            Long resultSum = levelSum.get(level)+root.val;
            if(resultSum == targetSum) {
                count++;
            }
            levelSum.set(level,resultSum);
        }
        if(root.val == targetSum) count++;

        levelSum.add((long)root.val);// add current level into levelSum

        count += pathSum(root.left, targetSum, levelSum);
        count += pathSum(root.right, targetSum, levelSum);

        // reset the level sum and remove last entry
        for(int level = 0; level < levelSum.size(); level++) {
            levelSum.set(level,levelSum.get(level)-root.val);
        }
        levelSum.removeLast();
        return count;
    }

    public static void main(String[] args) {
        PathSumIII ps3 = new PathSumIII();
        System.out.println("PathSum III: "+ps3.pathSum(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 8));
        System.out.println("PathSum III: "+ps3.pathSum(TreeNode.fromArray(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}), 22));
        System.out.println("PathSum III: "+ps3.pathSum(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,-10,-2,null,1}), 8));
        System.out.println("PathSum III: "+ps3.pathSum(TreeNode.fromArray(new Integer[]{1}), 1));
        System.out.println("PathSum III: "+ps3.pathSum(TreeNode.fromArray(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}), 0));
    }

}
