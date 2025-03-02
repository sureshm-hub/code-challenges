package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.*;


/**
 * from leet code: https://leetcode.com/discuss/interview-question/6466327/amazon-sde-1-round-2
 * Approach: DFS Traversals
 *      PostOrder for LCA
 *      InOrder for level and LevelNodeMap
 *
 * Complexity:
 *  Time: O(N^2)
 *  Space: O(N) for HashMap
 *
 */
public class BinaryTreeTargetSum {

    public int[] findTargetNodes(TreeNode root, int d, int target) {
        Map<Integer, List<LevelTreeNode>> nodeLevelMap = new HashMap<>();
        // traverse tree to nodeLevelMap
        traverseTree(root, nodeLevelMap, 0);
        // find nodes not on same level that sum to target
        Set<Integer> keys = nodeLevelMap.keySet();
        for(int key: keys) {
            List<LevelTreeNode> keyLevelNodes = nodeLevelMap.get(key);
            List<LevelTreeNode> targetLevelNodes = nodeLevelMap.get(target-key);
            // check if there is a targetLevelNodes
            if(targetLevelNodes != null) {
                for(LevelTreeNode keyLevelNode : keyLevelNodes) {
                    for(LevelTreeNode targetLevelNode : targetLevelNodes) {
                        if(keyLevelNode != targetLevelNode && keyLevelNode.level != targetLevelNode.level) { // check not on same level
                            // check for distance between nodes to match d
                            if(d == findDistance(root, keyLevelNode.node, targetLevelNode.node)) {
                                return new int[]{keyLevelNode.node.val, targetLevelNode.node.val};
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private TreeNode findLca(TreeNode root, TreeNode key, TreeNode target) {
        if(root == null || root == key || root == target) {
            return root;
        }
        TreeNode left = findLca(root.left, key, target);
        TreeNode right = findLca(root.right, key, target);

        if(left != null && right != null) { //both left and right are found
            return root;
        }

        return left == null ? right : left;
    }

    private int findDistance(TreeNode root, TreeNode key, TreeNode target) {
        TreeNode lca = findLca(root, key, target);
        int d1 = findLevelDistance(lca, key, 0);
        int d2 = findLevelDistance(lca, target, 0);
        return d1+d2;
    }

    // find level distance between a node and it's lca
    private int findLevelDistance(TreeNode root, TreeNode node, int level) {
        if(root == null) {
            return -1;
        }
        if(node == root){
            return level;
        }
        int left = findLevelDistance(root.left, node, level+1);
        if(left != -1) {
            return left;
        }
        return findLevelDistance(root.right, node, level+1);
    }

    private void traverseTree(TreeNode root, Map<Integer, List<LevelTreeNode>> nodeLevelMap, int level) {
        if(root == null) {
            return;
        }
        nodeLevelMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(new LevelTreeNode(root,level));
        traverseTree(root.left, nodeLevelMap, level+1);
        traverseTree(root.right, nodeLevelMap, level+1);
    }

    public static void main(String[] args) {
        BinaryTreeTargetSum bts = new BinaryTreeTargetSum();
        System.out.println("Binary Tree Target Sum: "+Arrays.toString(bts.findTargetNodes(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 3, 16)));
        System.out.println("Binary Tree Target Sum: "+Arrays.toString(bts.findTargetNodes(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 2, 8)));
        System.out.println("Binary Tree Target Sum: "+Arrays.toString(bts.findTargetNodes(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 2, 7)));
        System.out.println("Binary Tree Target Sum: "+Arrays.toString(bts.findTargetNodes(TreeNode.fromArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 1, 7)));
    }

}


class LevelTreeNode {
    TreeNode node;
    int level;

    LevelTreeNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}