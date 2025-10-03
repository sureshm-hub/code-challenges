package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {

        List<List<Integer>> nums = new ArrayList<>();

        collect(root, new ArrayList<>(), nums);

        // do sum
        int sum = 0;
        for(List<Integer> num : nums) {
            Collections.reverse(num);
            // System.out.println(" >> "+num);
            int temp = 0;
            int pv = 1;

            for(int d: num) {
                temp += d*pv;
                pv *= 10;
            }
            sum += temp;
        }

        return sum;
    }

    private void collect(TreeNode cur, List<Integer> path, List<List<Integer>> nums) {

        if(cur == null) return; // unbalanced case handled by the other leaf node

        if(cur.left == null && cur.right == null) {
            path.add(cur.val);
            nums.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(cur.val);
        collect(cur.left, path, nums);
        collect(cur.right, path, nums);
        path.remove(path.size() - 1);

        // System.out.println(" >>>> "+nums);
        return;
    }

    /**
     * Definition for a binary tree node.
     **/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
}
