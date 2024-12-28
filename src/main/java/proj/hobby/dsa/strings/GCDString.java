package proj.hobby.dsa.strings;

import java.util.*;

public class GCDString {


    public String gcdOfStrings(String str1, String str2){
        if(!(str1 + str2).equals(str2 + str1)) {
            return ""; // No common gcd
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        if( a  < b) {
            return gcd (b, a);
        }
        if(b == 0) {
            return a;
        }
        return gcd (b, a % b);
    }

    public String gcdOfStringBasic(String str1, String str2) {
        List<String> gcd1 = multiplesOfString(str1);
        List<String> gcd2 = multiplesOfString(str2);
        int i=0;
        String gcd = "";
        while(i < gcd1.size() && i < gcd2.size()) {
            if(gcd1.get(i).equals(gcd2.get(i))) {
                gcd = gcd1.get(i);
            }
            i++;
        }
        return gcd;
    }

    private List<String> multiplesOfString(String str1) {
        List<String> gcd = new ArrayList<>();
        gcd.add("");
        String temp = "";
        for(int i = 0; i <str1.length(); i++) {
            temp += str1.charAt(i);
            if(str1.length() % temp.length() == 0) {
                StringBuilder tempMult = new StringBuilder();
                int mul = str1.length()/temp.length();
                for(int j = 0; j < mul ; j ++) {
                    tempMult.append(temp);
                }
                if(tempMult.toString().equals(str1)){
                    gcd.add(temp);
                }
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        GCDString gcd = new GCDString();
        System.out.println(gcd.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcd.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcd.gcdOfStrings("ABC", "ABCABC"));
        System.out.println("Basic Solution ====");
        System.out.println(gcd.gcdOfStringBasic("ABCABC", "ABC"));
        System.out.println(gcd.gcdOfStringBasic("ABABAB", "ABAB"));
    }
}
