package proj.hobby.dsa.array;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description
 */
public class FindNUnique {

    public int[] sumZero(int n) {
        int[] arr = new int[n];
        for(int i = 0, j = n-1; i <= j; i++, j--) {
            if (i == j) {
                arr[i] = 0;
                break;
            }
            arr[i] = n-i;
            arr[j] = -n+i;
        }
        return arr;
    }
}
