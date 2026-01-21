package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] nextBoard = new int[rows][cols];
        int[][] nbrs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1,1}, {1, -1}, {1, 1}};
        for(int r = 0;  r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                int liveNbr = 0;
                for(int[] nbr : nbrs) {
                    int x = nbr[0] + r, y = nbr[1] + c;
                    if(x >= 0 && x < rows && y >= 0 && y <  cols && board[x][y] == 1) {
                        liveNbr++;
                    }
                }
                nextBoard[r][c] = nextState(board[r][c], liveNbr);
            }
        }

        for(int r = 0; r < rows; r++) {
            System.arraycopy(nextBoard[r], 0, board[r], 0, cols);
        }

    }

    private int nextState(int cur, int liveNbrs) {
        if(cur == 1) {
            if (liveNbrs == 2 || liveNbrs == 3) return 1;
            return 0;
        }
        if(liveNbrs == 3) return 1;
        return 0;
    }

    public void gameOfLife2(int[][] board) {

        int M = board.length;
        int N = board[0].length;

        int[][] neighbs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,1},{-1,-1},{1,-1}};

        int[][] temp = new int[M][N];

        for(int i = 0 ; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int live = 0;
                for(int[] nb : neighbs) {
                    int newX = i + nb[0], newY = j + nb[1];
                    if(newX >= 0 && newY >=0 && newX < M && newY < N && board[newX][newY] == 1) live++;
                }

                if(board[i][j] == 1) {
                    temp[i][j] = switch(live) {
                        case 2,3 -> 1;
                        default -> 0;
                    };
                } else {
                    temp[i][j] = switch(live) {
                        case 3 -> 1;
                        default -> 0;
                    };
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
}
