package proj.hobby.dsa;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 */

public class LetterCombination {

    Map<Character,char[]> phone = new HashMap<>();

    {
        phone.put('2', new char[]{'a','b','c'});
        phone.put('3', new char[]{'d','e','f'});
        phone.put('4', new char[]{'g','h','i'});
        phone.put('5', new char[]{'j','k','l'});
        phone.put('6', new char[]{'m','n','o'});
        phone.put('7', new char[]{'p','q','r','s'});
        phone.put('8', new char[]{'t','u','v'});
        phone.put('9', new char[]{'w','x','y','z'});
    }

    public List<String> letterCombinationsBFS(String digits) {
        if(digits == null || digits.isEmpty() ) {
            return new ArrayList<>();
        }
        char[] nums = digits.toCharArray();
        List<String> combos = new ArrayList<>();
        combos.add("");
        for(char num: nums) {
            List<String> temp = new ArrayList<>();
            char[] map = phone.get(num);
            for(char c: map) {
                for(String prev : combos) {
                    temp.add(prev+c);
                }
            }
            combos = temp;
        }
        return combos;
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> combos = new ArrayList<>();
        dfs(digits, combos, 0, new StringBuilder());
        return combos;
    }

    private void dfs(String digits, List<String> combos, int index, StringBuilder current){
        if(index == digits.length()){
            combos.add(current.toString());
            return;
        }
        char[] value = phone.get(digits.charAt(index));
        for(char c : value) {
            current.append(c);
            dfs(digits, combos,index+1, current);
            current.deleteCharAt(index);
        }
    }
}
