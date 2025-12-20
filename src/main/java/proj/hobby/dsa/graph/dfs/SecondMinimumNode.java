package proj.hobby.dsa.graph.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree
 */
public class SecondMinimumNode {

    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        if(root.left == null)  return -1;

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        if(list.size() < 2) return -1;

        list.sort(Comparator.naturalOrder());

        for(int num : list) {
            if(num != list.get(0)) return num;
        }
        return -1;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
