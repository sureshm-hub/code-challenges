package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/minesweeper/description
 */
public class MineSweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click);
        return board;
    }

    private void dfs(char[][] board, int[] click) {
        int M = board.length;
        int N = board[0].length;

        int cr = click[0], cc = click[1];

        if(cr < 0 || M <= cr) return;
        if(cc < 0 || N <= cc) return;

        if(board[cr][cc] != 'M' && board[cr][cc] != 'E') return; // already revealed

        if(board[cr][cc] == 'M') {
            board[cr][cc] = 'X';
            return;
        }

        int[][] dirs = new int[][]{{0,-1}, {1,0}, {0,1}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int  mines = 0;
        if(board[cr][cc] == 'E') {
            for(int[] dir : dirs) {
                int newCr = cr + dir[0];
                int newCc = cc + dir[1];
                if((0 <= newCr && newCr < M) && (0 <= newCc && newCc < N) && board[newCr][newCc] == 'M') {
                    mines++;
                }
            }
            if(mines == 0) {
                board[cr][cc] = 'B';
            } else {
                board[cr][cc] = (char) ('0' + mines);
                return;// can not continue
            }
        }

        // reveal adjacent
        for(int[] dir : dirs) {
            int newCr = cr + dir[0];
            int newCc = cc + dir[1];
            dfs(board, new int[] {newCr, newCc});
        }
    }
}
