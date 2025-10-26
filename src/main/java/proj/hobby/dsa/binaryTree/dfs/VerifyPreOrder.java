package proj.hobby.dsa.binaryTree.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreOrder {

    public boolean isValidSerialization(String preorder) {

        if("#".equals(preorder)) return true; // null is valid

        Deque<Integer> stack = new ArrayDeque<Integer>(); // #child = 0, 1, 2

        String[] nums = preorder.split(",");
        int n = nums.length;
        for( int i = 0; i < n; i++) {
            String num = nums[i];
            if("#".equals(num)) {

                if(stack.isEmpty()) return false; // null needs a parent

                int parent = stack.pop();
                ++parent;

                while(parent == 2 && !stack.isEmpty()) {
                    parent  = stack.pop();
                    parent++;
                }
                if(parent < 2) {
                    stack.push(parent);
                }
                if(stack.isEmpty()) return i == n - 1; // did we use all elements?
            } else {
                stack.push(0);
            }
        }
        return stack.isEmpty();
    }
}
