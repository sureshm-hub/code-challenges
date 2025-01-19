package proj.hobby.dsa.dp.multiDimensional;

/**
 * https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: 2D Array DP
 *
 * Complexity:
 *  Time: O(M*N) M is word1 length & N is word2 length
 *  Space: O(M*N)
 *
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        final int M = word1.length();
        final int N = word2.length();

        int[][] dp = new int[N+1][M+1];

        //initialize 1st row and column
        for(int i = 1 ; i <= M ; i++) {
            dp[0][i] = i;// delete chars of word1 to get word 2 which is empty string for first row
        }
        for(int i = 1 ; i <= N ; i++) {
            dp[i][0] = i; // insert chars to word1 which is empty string for first col to form word2
        }

        for(int i  = 1; i <= N; i++) {
            char c1 = word2.charAt(i-1);
            for(int j = 1; j <= M; j++) {
                char c2 = word1.charAt(j-1);
                int replaceEdit = (c1 == c2) ? 0 : 1;
                dp[i][j] =  Math.min(1+dp[i][j-1] ,// delete j
                        Math.min(1+dp[i-1][j] ,// insert i
                                replaceEdit+dp[i-1][j-1]));	// replace i with j
            }
        }
        return dp[N][M];
    }

    /**
     * Approach: recursion
     * complexity:
     *  Time: O(2^(M+N)) M - is length of word1 and N - is length of word2
     *  Space: O(1)
     */
    public int minDistanceRecursion(String word1, String word2) {
        return minDistanceHelper(word1, 0, word2, 0);
    }

    private int minDistanceHelper(String word1, int index1, String word2, int index2) {
        if(index1 == word1.length() && index2 == word2.length()) {
            return 0;// all edits are done
        }

        // we are at end of word2  so we can  delete remaining chars from word1
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

        // we are at end of word1 so  we can add remaining chars to word1
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        int replace  =  0;
        if(word1.charAt(index1) != word2.charAt(index2)) {
            replace = 1;
        }
        return Math.min(replace + minDistanceHelper(word1, index1+1, word2, index2+1), // replace Edits
                Math.min( 1 + minDistanceHelper(word1, index1+1, word2, index2), // delete char from word 1
                        1 + minDistanceHelper(word1, index1, word2, index2+1))); // insert char into word 1
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println("Edit Distance: "+ed.minDistance("", "h"));
        System.out.println("Edit Distance: "+ed.minDistance("h", "h"));
        System.out.println("Edit Distance: "+ed.minDistance("h", "ho"));
        System.out.println("Edit Distance: "+ed.minDistance("ho", "h"));
        System.out.println("Edit Distance: "+ed.minDistance("oh", "h"));
        System.out.println("Edit Distance: "+ed.minDistance("h", "oh"));
        System.out.println("Edit Distance: "+ed.minDistance("horse", "ros"));
        System.out.println("Edit Distance: "+ed.minDistance("horse", "orse"));
        System.out.println("Edit Distance: "+ed.minDistance("intention", "execution"));

        System.out.println("======= Recursion");
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("", "h"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("h", "h"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("h", "ho"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("ho", "h"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("oh", "h"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("h", "oh"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("horse", "ros"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("horse", "orse"));
        System.out.println("Edit Distance: "+ed.minDistanceRecursion("intention", "execution"));
    }
}
