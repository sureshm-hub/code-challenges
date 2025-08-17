package proj.hobby.dsa.maps;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 */
public class FindReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        Set<Character> pat = new HashSet<>();
        for(char c : pattern.toCharArray()) {
            pat.add(c);
        }

        List<String> output = new ArrayList<>();
        for(String word : words){

            Set<Character> wp = new HashSet<>();
            for(char c : word.toCharArray()) {
                wp.add(c);
            }

            if(pat.size() == wp.size() && pattern.length() == word.length()) {

                StringBuilder wordResult = new StringBuilder();
                Map<Character, Character> charMap = new HashMap<>();
                for(int i =0; i <pattern.length(); i++){
                    char c = pattern.charAt(i);
                    charMap.putIfAbsent(word.charAt(i), c);
                    wordResult.append(charMap.get(word.charAt(i)));
                }
                if(wordResult.toString().equals(pattern)) {
                    output.add(word);
                }
            }
        }
        return output;
    }
}
