package proj.hobby.dsa.dp;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {

        // int[] counter = {0};

        Map<TreeNode, int[]> memo = new HashMap<>();

        int[] robbed = dfs(root, memo);//, counter[0]++, counter, false);

        // int taken = memo.get(0+"_yes");
        // int skipped = memo.get(0+"_no");

        int max = Math.max(robbed[0], robbed[1]); // skip, take
        return max;
    }

    private int[] dfs(TreeNode node, Map<TreeNode, int[]>  memo) { //}, int idx, int[] counter, boolean taken) {
        if(node == null) return new int[] {0, 0};

        // String key = idx+(taken ? "_yes": "_no");

        if(memo.containsKey(node)) return memo.get(node);

        int[] L = dfs(node.left, memo);
        int[] R = dfs(node.right, memo);

        int take = node.val + L[0] + R[0]; // dhildren should be skipped

        int skip = Math.max(L[0], L[1]) + Math.max(R[0], R[1]); //free to choose any children

        int[] result = {skip, take};
        memo.put(node, result);
        // int incl = node.val
        //             + dfs(node.left, memo, counter[0]++, counter, !taken)
        //             + dfs(node.right, memo, counter[0]++,  counter, !taken);
        // memo.put(idx+"_yes", incl);


        // int excl = dfs(node.left, memo, counter[0]++,  counter, taken)
        //             + dfs(node.right, memo, counter[0]++,  counter, taken);
        // memo.put(idx+"_no", excl);

        // int max = Math.max(take, skip);
        return result;
    }
}
