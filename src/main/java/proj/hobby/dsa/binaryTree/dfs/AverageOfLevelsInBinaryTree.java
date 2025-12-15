package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description
 *
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Integer> levels = new HashMap<>();
        List<Double> result = new ArrayList<>();
        dfs(root, levels, result, 0);
        return result;
    }

    private void dfs(TreeNode node, Map<Integer, Integer> levels, List<Double> result, int cur) {
        if(node == null) return;

        levels.merge(cur, 1, Integer::sum);
        if(result.size() <= cur) {
            result.add((double)node.val);
        } else {
            int count = levels.get(cur);
            double avg = (result.get(cur) * (count - 1) + node.val) / count;
            result.set(cur, avg);
        }
        dfs(node.left, levels, result, cur + 1);
        dfs(node.right, levels, result, cur + 1);
    }

}
