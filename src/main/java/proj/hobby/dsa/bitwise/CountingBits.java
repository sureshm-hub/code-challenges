package proj.hobby.dsa.bitwise;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int N) {
        int[] ans = new int[N+1];
        for(int i=0; i <= N; i++) {
            int num = i;
            int count = 0;
            while(num > 0) {
                count += num & 1;
                num >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 25;
        CountingBits cb = new CountingBits();
        int[] counts = cb.countBits(N);
        System.out.println("Counting Bits:"+Arrays.stream(counts).boxed().toList());
    }
}
