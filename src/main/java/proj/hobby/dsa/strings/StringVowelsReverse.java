package proj.hobby.dsa.strings;

public class StringVowelsReverse {

    public String reverseVowels(String s) {
        int i =0, j = s.length()-1;
        char[] c = s.toCharArray();
        while(i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            boolean isIVowel =  isVowel(ci);
            boolean isJVowel = isVowel(cj);
            if( isIVowel && isJVowel ) {
                c[i] = cj;
                c[j] = ci;
                i++;
                j--;
            }
            if(!isIVowel) {
                c[i] = ci;
                i++;
            }
            if(!isJVowel) {
                c[j] = cj;
                j--;
            }
        }
        return new String(c);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c)  != -1;
    }

    public static void main(String[] args) {
        StringVowelsReverse svr = new StringVowelsReverse();
        String reverse = svr.reverseVowels("IceCreAm");
        System.out.println("String Vowels Reverse: "+reverse);

        reverse = svr.reverseVowels("leetcode");
        System.out.println("String Vowels Reverse:"+reverse);

        reverse = svr.reverseVowels("leeaiode");
        System.out.println("String Vowels Reverse:"+reverse);

        reverse = svr.reverseVowels("a");
        System.out.println("String Vowels Reverse:"+reverse);

        reverse = svr.reverseVowels("abe");
        System.out.println("String Vowels Reverse:"+reverse);

        reverse = svr.reverseVowels("ae");
        System.out.println("String Vowels Reverse:"+reverse);

        reverse = svr.reverseVowels("xyzstpl");
        System.out.println("String Vowels Reverse:"+reverse);
    }
}
