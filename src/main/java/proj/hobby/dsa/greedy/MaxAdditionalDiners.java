package proj.hobby.dsa.greedy;

import java.util.Arrays;

/**
    https://www.metacareers.com/profile/coding_puzzles?puzzle=203188678289677

 */
public class MaxAdditionalDiners {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long maxAdditionalDiners = 0L;
        long prev = 0L;
        for(int i =0; i < M; i++) {
            long Si = S[i];
            long distance = (prev == 0) ? K : 2*K;
            maxAdditionalDiners += getMaxDinersCount(S[i]-prev-1-distance, K);
            prev = Si;
        }
        if(M == 0) {
            maxAdditionalDiners += getMaxDinersCount(N - prev, K);
        } else {
            maxAdditionalDiners += getMaxDinersCount(N - prev - K, K);
        }
        return maxAdditionalDiners;
    }

    private long getMaxDinersCount(long N, long K) {
        long diners = N/(K+1);
        if(N % (K+1) > 0) {
            diners++;
        }
        return diners;
    }

}
