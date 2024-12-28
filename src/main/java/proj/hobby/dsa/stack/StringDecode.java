package proj.hobby.dsa.stack;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Stack
 *
 * Complexity:
 *  Time: O(K) - K length of decoded string
 *  Space: O(K) - K length of decoded string
 *
 */
public class StringDecode {

    public String decodeString(String s) {
        Stack<Integer> multiplierStack = new Stack<>();
        Stack<StringBuilder> partsStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currMultiplier = 0;
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                currMultiplier = 10 * currMultiplier + (c - '0');
            } else if(c == '[') {
                multiplierStack.push(currMultiplier);
                partsStack.push(currString);
                currString = new StringBuilder();
                currMultiplier = 0;
            } else if(c == ']') {
                int multiplier = multiplierStack.pop();
                StringBuilder decodedString = new StringBuilder();
                while(multiplier > 0) {
                    decodedString.append(currString);
                    multiplier --;
                }
                currString = partsStack.pop().append(decodedString);
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }

    public String decodeStringV1(String s) {
        StringBuilder decode = new StringBuilder();
        Stack<Integer> multiplier = new Stack<>();
        Stack<String> parts = new Stack<>();
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(multiplier.size() > parts.size()) { // extract part
                StringBuilder part = new StringBuilder();
                while("123456789[]".indexOf(c) == -1) {
                    part.append(c);
                    c = s.charAt(++i);
                }
                parts.push(part.toString());
            }
            if("123456789".indexOf(c) != -1) { //extract multiplier
                StringBuilder multiple = new StringBuilder();
                while(c != '[') {
                    multiple.append(c);
                    c = s.charAt(++i);
                }
                multiplier.push(Integer.parseInt(multiple.toString()));
            }
            if(c == ']') { // pop multiple and decode
                int multiple = multiplier.pop();
                String part = parts.pop();
                StringBuilder partDecode = new StringBuilder();
                while (multiple > 0) {
                    partDecode.append(part);
                    multiple--;
                }
                if(parts.isEmpty()){
                    decode.append(partDecode);
                } else {
                    String parent = parts.pop();
                    parts.push(parent+partDecode);
                }
            } else if(multiplier.size() == parts.size()) {
                decode.append(c);
            }
        }
        return decode.toString();
    }

    public static void main(String[] args) {
        StringDecode decoder = new StringDecode();
        System.out.println("String Decode: "+decoder.decodeString("3[a]2[bc]"));
        System.out.println("String Decode: "+decoder.decodeString("3[a2[c]]"));
        System.out.println("String Decode: "+decoder.decodeString("2[abc]3[cd]ef"));
        System.out.println("String Decode: "+decoder.decodeString("abcef"));
        System.out.println("String Decode: "+decoder.decodeString("3[a]2[bc]XYZ3[a2[c12[i]]]UVW"));
        System.out.println("String Decode: "+decoder.decodeString("2[2[y]]"));
        System.out.println("String Decode: "+decoder.decodeString("1[2[y]pq]"));
        System.out.println("String Decode: "+decoder.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

}
