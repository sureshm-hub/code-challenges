package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class CountBattleShips {

    public int countBattleships(char[][] board) {
        int M = board.length;
        int N = board[0].length;

        boolean[][] visited = new boolean[M][N];
        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 'X' & !visited[i][j]) {
                    count++;
                    mark(board, i, j, visited);
                }
            }
        }
        return count;
    }

    private void mark(char[][] board, int x, int y, boolean[][] visited) {
        int M = board.length;
        int N = board[0].length;

        if(x >= M || y >= N || board[x][y] != 'X') return;

        visited[x][y] = true;
        int[][] dirs = {{1, 0}, {0, 1}};


        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX < M && newY < N && !visited[newX][newY]) {
                mark(board, newX, newY, visited);
            }
        }
    }
}
