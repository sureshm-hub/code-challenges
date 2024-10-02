package proj.hobby.leet;

import java.util.HashMap;
import java.util.Map;

/**

 Problem:
    https://leetcode.com/problems/interleaving-string/description/

 Clarifying Q's:

 PsuedoCode:
     S3 = IL(S1, S2)
     S3[1,n]    = (S3[0] == S1[0] && IL(S1[1,n], S2) ) ||
                 (S3[0] == S2[0] && IL(S1, S2[1,n])

 Complexity:
    Time Complexity:
             O(2 ^(N1+N2)  - N1 & N2 are lengths of the strings  - Brute Force
             O(N1*N2) - Memoized

 */
public class Intereleave {

    Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] c = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return isInterleave(s1.toCharArray(), 0, s2.toCharArray(),0, s3.toCharArray(), 0, c);
    }

    private boolean isInterleave(char[] s1, int i1, char[] s2, int i2, char[] s3, int i3, Boolean[][][] c) {

        if(i1== s1.length && i2 == s2.length && i3 == s3.length) {
            return  true;
        }
        if(i1 == s1.length && i2==s2.length) {
            // Note: i3 is not at  s3.length, i3 != s3.length is always true when reached
            return false;
        }
        if(i3 == s3.length ) {
            // Note: i1!= s1.length || i2 != s2.length is always true when reached
            return false;
        }
        if(c[i1][i2][i3] != null) {
            return c[i1][i2][i3];
        }

        if (i1 == s1.length) {
            boolean result = ((s2[i2] == s3[i3]) && isInterleave(s1, i1, s2,i2+1, s3,i3+1, c));
            c[i1][i2][i3] = result;
            return result;
        }

        if (i2 == s2.length) {
           boolean result = ((s1[i1] == s3[i3]) && isInterleave(s1, i1+1, s2,i2, s3,i3+1, c));
           c[i1][i2][i3] = result;
           return result;
        }

        boolean result =  ((s1[i1] == s3[i3]) && isInterleave(s1, i1+1, s2,i2, s3,i3+1, c)) ||
                ((s2[i2] == s3[i3]) && isInterleave(s1, i1, s2,i2+1, s3,i3+1, c));
        c[i1][i2][i3] = result;
        return result;
    }

    /**
     *  This interLeave uses HashMap for cache and is more slower because of key look up operations, but improves memory consumption
     *  as we don't have to allocate m*n*k boolean slots upfront
     *
     * @param s1
     * @param i1
     * @param s2
     * @param i2
     * @param s3
     * @param i3
     * @return
     */
    private boolean isInterleaveHashMap(char[] s1, int i1, char[] s2, int i2, char[] s3, int i3) {

        if(i1== s1.length && i2 == s2.length && i3 == s3.length) {
            return  true;
        }
        if(i1 == s1.length && i2==s2.length) {
            // Note: i3 is not at  s3.length, i3 != s3.length is always true when reached
            return false;
        }
        if(i3 == s3.length ) {
            // Note: i1!= s1.length || i2 != s2.length is always true when reached
            return false;
        }
        String key = i1+","+i2+","+i3;
        if(cache.get(key) != null) {
            return cache.get(key);
        }

        if (i1 == s1.length) {
            boolean result = ((s2[i2] == s3[i3]) && isInterleaveHashMap(s1, i1, s2,i2+1, s3,i3+1));
            cache.put(key, result);
            return result;
        }

        if (i2 == s2.length) {
            boolean result = ((s1[i1] == s3[i3]) && isInterleaveHashMap(s1, i1+1, s2,i2, s3,i3+1));
            cache.put(key, result);
            return result;
        }

        boolean result =  ((s1[i1] == s3[i3]) && isInterleaveHashMap(s1, i1+1, s2,i2, s3,i3+1)) ||
                ((s2[i2] == s3[i3]) && isInterleaveHashMap(s1, i1, s2,i2+1, s3,i3+1));
        cache.put(key, result);
        return result;
    }
}
