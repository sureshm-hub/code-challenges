package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();

        if(words.length != pattern.length()) return false;

        for(int i = 0; i < words.length; i++) {
            charMap.putIfAbsent(pattern.charAt(i), words[i]);
            wordMap.putIfAbsent(words[i], pattern.charAt(i));
        }

        if(charMap.size() != wordMap.size()) return false;

        StringBuilder fromWord = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            fromWord.append(wordMap.get(words[i]));
        }

        if(!pattern.equals(fromWord.toString())) return false;

        StringBuilder fromChars = new StringBuilder();
        for(int i = 0; i < pattern.length(); i++) {
            fromChars.append(charMap.get(pattern.charAt(i))).append(" ");
        }

        return fromChars.toString().trim().equals(s.trim());
    }

    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        Map<Character, String> patMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        int i = 0;
        for(char c : pattern.toCharArray()) {
            String word = words[i];
            if(patMap.containsKey(c)) {
                if(!patMap.get(c).equals(words[i++]) ) {
                    return false;
                } else {
                    continue;
                }
            } else {
                patMap.put(c, words[i++]);
            }

            if(wordMap.containsKey(word)) {
                if(! wordMap.get(word).equals(c)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                wordMap.put(word, c);
            }
        }

        return true;
    }
}
