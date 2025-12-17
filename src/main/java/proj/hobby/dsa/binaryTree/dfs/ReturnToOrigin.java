package proj.hobby.dsa.binaryTree.dfs;

/**
 *
 * https://leetcode.com/problems/robot-return-to-origin
 */
public class ReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'R') x += 1;
            else if(c == 'L') x += -1;
            else if(c == 'U') y += -1;
            else y += 1; // y == 'D'
        }
        return x == 0 && y == 0;
    }
}
