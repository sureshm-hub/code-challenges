package proj.hobby.dsa;

// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(s == null || t == null) return s == null && t == null;
        int currS = 0;
        int currT = 0;
        while (currT < t.length() && currS <s.length()) {
            char sc = s.charAt(currS);
            char st = t.charAt(currT);
            if(sc == st) {
                currS++;
            }
            currT++;
        }
        return currS == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence iss =new IsSubsequence();
        boolean found = iss.isSubsequence("abc", "ahbgdc");
        System.out.println("found: "+found);

        found = iss.isSubsequence("axc", "ahbgdc");
        System.out.println("found: "+found);

        found = iss.isSubsequence("axc", null);
        System.out.println("found: "+found);

        found = iss.isSubsequence("ac", "hbagdcdf");
        System.out.println("found: "+found);
    }
}
