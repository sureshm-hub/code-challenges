package proj.hobby.dsa.binaryTree.dfs;

import java.util.*;

import proj.hobby.dsa.binaryTree.TreeNode;


/**
 * https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: DFS
 *
 * Complexity:
 *  Time: O(N1+N2) - N1 & N2 are nodes in 2 trees
 *  Space: O(L1+L2) - L1 & L2 are leaf nodes
 *
 *
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        collectLeafNodes(root1, firstList);
        collectLeafNodes(root2, secondList);

        // compare leaf sequence
        return firstList.equals(secondList);
    }

    private int collectLeafNodes(TreeNode root, List<Integer> collector) {

        if(root == null) {
            return 0;
        }

        int left = collectLeafNodes(root.left, collector);
        int right = collectLeafNodes(root.right, collector);

        // if leaf node collect value
        if(left == 0 && right == 0) {
            collector.add(root.val);
        }
        return left + right + 1;
    }

    public static void main(String[] args) {
        LeafSimilarTrees lst = new LeafSimilarTrees();
        TreeNode root1 = TreeNode.fromArray(new Integer[] {3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = TreeNode.fromArray(new Integer[] {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        System.out.println("Leaf Similar Tree: "+lst.leafSimilar(root1, root2));
    }

}
