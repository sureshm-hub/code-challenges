package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description
 *
 */
public class FindDuplicateSubtree {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> counts  = new HashMap<>();
        List<TreeNode> dups = new ArrayList<>();
        encode(root, counts, dups);
        return dups;
    }

    private String encode(TreeNode node, Map<String, Integer> counts, List<TreeNode> dups) {
        if(node == null) return "";

        String encoded = node.val + "#" + encode(node.left, counts, dups)+ "#" + encode(node.right, counts, dups);
        if(counts.merge(encoded, 1, Integer::sum) == 2)
            dups.add(node);
        return encoded;
    }
}
