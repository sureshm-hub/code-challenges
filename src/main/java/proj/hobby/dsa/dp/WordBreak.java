package proj.hobby.dsa.dp;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/word-break
 *
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        Map<Integer, Boolean> memo = new HashMap<>();
        words.addAll(wordDict);
        return wordBreak(s, 0, words, memo);
    }

    private boolean wordBreak(String s, int start, Set<String> wordDict, Map<Integer, Boolean> memo) {

        if(start == s.length()) return true;

        if(memo.containsKey(start)) return memo.get(start);

        boolean found = false;
        for(int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            if(!found  && wordDict.contains(sub)) {
                found = wordBreak(s, i + 1, wordDict, memo);
            }
        }
        memo.put(start, found);
        return found;
    }
}
