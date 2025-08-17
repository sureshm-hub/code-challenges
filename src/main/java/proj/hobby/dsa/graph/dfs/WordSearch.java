package proj.hobby.dsa.graph.dfs;

/**
 * https://leetcode.com/problems/word-search/
 *
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j , int index, String word) {
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, i+1, j, index+1, word) ||
                dfs(board, i-1, j, index+1, word) ||
                dfs(board, i, j+1, index+1, word) ||
                dfs(board, i, j-1, index+1, word);
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        WordSearch search = new WordSearch();
        char[][] board  = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("Word exists: "+search.exist(board, "ABCCED"));
        System.out.println("Word exists: "+search.exist(board, "SEE"));
        System.out.println("Word exists: "+search.exist(board, "ABCB"));
    }
}
