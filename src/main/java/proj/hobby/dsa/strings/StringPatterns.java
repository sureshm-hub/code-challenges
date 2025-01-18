package proj.hobby.dsa.strings;

import java.util.*;

public class StringPatterns {

    /**
     * n(n+1)/2 substrings - Non recursive typically
     *
     * @param s
     * @return
     */
    public List<String> generateSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(s.substring(i, j)); // Contiguous substring from i to j-1
            }
        }
        return substrings;
    }

    /**
     * 2^n subsequences - recursive typically
     *
     * @param s
     * @param index
     * @param current
     * @param subsequences
     */
    public void generateSubsequences(String s, int index, String current, List<String> subsequences) {
        if (index == s.length()) {
            subsequences.add(current); // Add current subsequence to the list
            return;
        }
        // Exclude the current character
        generateSubsequences(s, index + 1, current, subsequences);
        // Include the current character
        generateSubsequences(s, index + 1, current + s.charAt(index), subsequences);
    }

    public static void main(String[] args) {
        StringPatterns sp = new StringPatterns();
        String myString = "abcd";
        System.out.println("Substring: \n"+sp.generateSubstrings(myString));
        System.out.println("====");
        List<String> result = new ArrayList<>();
        sp.generateSubsequences(myString,0, "", result);
        System.out.println("Subsequence: \n"+result);
    }


}
