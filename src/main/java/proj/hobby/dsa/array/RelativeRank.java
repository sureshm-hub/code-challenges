package proj.hobby.dsa.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://leetcode.com/problems/relative-ranks/description
 */
public class RelativeRank {

    public String[] findRelativeRanks(int[] score) {

        int N = score.length;
        int[][] indexScore = new int[N][2];
        for(int i = 0; i < N; i++) {
            indexScore[i][0] = score[i];
            indexScore[i][1] = i;
        }
        Arrays.sort(indexScore, Comparator.comparingInt(x -> x[0]));

        String[]  placements = new String[N];
        for(int i = 0; i < N; i++) {
            int place = N - i;
            placements[indexScore[i][1]] = switch (place) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> Integer.toString(place);
            };
        }

        return placements;
    }
}
