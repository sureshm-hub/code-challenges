package proj.hobby.dsa.array;

/**
 *
 * https://www.metacareers.com/profile/coding_puzzles?puzzle=870874083549040
 *
 *
 *
 */
public class Photography {

    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        char[] cells = C.toCharArray();
        int result = 0;
        for(int p = 0; p < N; p++) {
            for(int a = 0; a < N; a++) {
                for(int b =0; b < N; b++) {
                    int d1 = Math.abs(a - p);
                    int d2 = Math.abs(b - a);
                    if(X <= d1 && X <= d2 && d1 <= Y && d2 <= Y
                            && cells[p]== 'P' && cells[a] == 'A' && cells [b] == 'B'
                            &&( (p < a  && a < b) || (b < a  && a < p))) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
