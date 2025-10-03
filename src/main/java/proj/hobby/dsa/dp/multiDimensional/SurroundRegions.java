package proj.hobby.dsa.dp.multiDimensional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/surrounded-regions/description
 *
 */
public class SurroundRegions {

    int M = 0;
    int N = 0;

    char O = 'O';
    char X = 'X';

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;

        Set<String> processed = new HashSet<>();

        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == O  && !processed.contains(i+", "+j)) {
                    boolean[][] mark = new boolean[M][N];
                    List<int[]> border = new ArrayList<>();
                    List<int[]> region = new ArrayList<>();
                    mark[i][j] = true;
                    connect(board, i, j, mark, border, region);

                    // in-place capture when border is surrounded
                    for(int[] r : region) {
                        if(border.size() == 0) {
                            board[r[0]][r[1]] = X;
                        } else {
                            processed.add(r[0]+", "+r[1]);
                        }
                    }
                }
            }
        }

    }

    private void connect(char[][] board, int i, int j, boolean[][] mark, List<int[]> border, List<int[]> region) {

        region.add(new int[]{i, j});

        for(int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if(newI >= 0 &&  newI < M && newJ >= 0 && newJ < N) {
                if(board[newI][newJ] == X) {
                    ; // only capture boarder when it is outside edge;
                } else if(!mark[newI][newJ]) {
                    mark[newI][newJ] = true;
                    connect(board, newI, newJ, mark, border, region);
                }
            } else {
                border.add(new int[]{-1, -1});
            }
        }
    }
}
