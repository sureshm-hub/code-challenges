package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/surrounded-regions
 *
 *  A DFS based approach
 *
 *  Time Complexity: O(M * N)
 */
public class SurroundRegions {

    private int M = 0;
    private int N = 0;

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                boolean[][] visited = new boolean[M][N];
                if(isSurrounded(board, i, j, visited)) {
                    capture(board, i, j);
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, int i, int j, boolean[][] visited) {
        if((i == 0 || i == M - 1 || j == 0 || j == N - 1) && board[i][j] == 'O') return false;

        if(board[i][j] == 'X') return true;

        visited[i][j] = true;
        int[][] dirs = new int[][]{{-1, 0},{1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            // check bounds & previous visit's
            if(!(newI < 0 || newI >= M || newJ < 0 || newJ >= N)  &&  !visited[newI][newJ]) {
                //if not surrounded by X in any neigbor then return false
                if(!isSurrounded(board, newI, newJ, visited)) return false;
            }
        }
        return true;
    }

    private void capture(char[][] board, int i, int j) {
        if(i < 0 || i >= M || j < 0 || j >= N) return;

        if(board[i][j] == 'X') return;

        if(board[i][j] == 'O') board[i][j] = 'X';

        capture(board, i + 1, j);
        capture(board, i - 1, j);
        capture(board, i, j + 1);
        capture(board, i, j - 1);
    }
}
