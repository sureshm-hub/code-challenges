package proj.hobby.dsa.binarySearch;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> modes = new HashMap<>();
        findMode(root, modes);
        // final int max = modes.values().stream().max(Comparator.naturalOrder()).orElse(0);
        final int max = modes.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        Map<Integer, Integer> maxModes = modes.entrySet().stream().filter(entry -> entry.getValue() == max)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return maxModes.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    private void findMode(TreeNode node, Map<Integer, Integer> modes) {

        if(node == null) return;

        modes.merge(node.val, 1, (old, one) -> old + one);

        findMode(node.left, modes);
        findMode(node.right, modes);
    }
}
