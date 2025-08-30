package proj.hobby.dsa.array;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        int rows = board.length, cols = board[0].length;

        // validate rows
        for(int i=0; i < rows; i++) {
            Set<Character> curr = new HashSet<>();
            for(int j=0; j < cols; j++) {
                char val = board[i][j];
                if(!curr.contains(val)) {
                    if(val != '.') curr.add(val);
                } else {
                    //System.out.println(i+" >> "+curr);
                    return false;
                }
            }
        }

        // validate cols
        for(int i=0; i < rows; i++) {
            Set<Character> curr = new HashSet<>();
            for(int j=0; j < cols; j++) {
                char val = board[j][i];
                if(! curr.contains(val)) {
                    if(val != '.') curr.add(val);
                } else {
                    //System.out.println(j+" >> "+curr);
                    return false;
                }
            }
        }

        // validate grids
        int[][] offsets= new int[][]{{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for(int k=0; k < offsets.length; k++) {
            int xOffset =offsets[k][0], yOffSet=offsets[k][1], size=3;
            Set<Character> curr = new HashSet<>();
            for(int i=xOffset; i < xOffset+size; i++) {
                for(int j=yOffSet; j < yOffSet+size; j++) {
                    char val = board[i][j];
                    if(! curr.contains(val)) {
                        if(val != '.') curr.add(val);
                    } else {
                        //System.out.println(k+" >> "+curr);
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
