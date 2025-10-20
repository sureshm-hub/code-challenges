package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {

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
