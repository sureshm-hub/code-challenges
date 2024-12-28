package proj.hobby.dsa.strings;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        return String.join(" ", reverse(split));
    }

    private String[] reverse(String[] words) {
        int i = 0 , j = words.length -1;
        while( i < j) {
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }
        return words;
    }

    public String reverseWordsIterative(String s) {
        char[] chars = s.trim().toCharArray(); // trim
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ' && chars[i-1] == ' ') {
                continue; // clean up extra spaces
            }
            sb.append(chars[i]);
        }
        chars = sb.toString().toCharArray();
        reverse(chars, 0 , chars.length-1); // reverse string
        int start = 0;
        for(int i = 0 ; i < chars.length; i++) {
            if(' '== chars[i] || i == chars.length-1) {
                boolean wordend = i-1 >= 0  && chars[i-1] != ' ';
                if(wordend) {
                    int end = i == chars.length-1 ? i : i-1;
                    reverse(chars, start, end);
                }
                start = i+1;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] s, int start, int end) {
        int i = start, j = end;
        while( i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String reversed = rw.reverseWords("the sky is blue");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWords("  the    sky   is    blue  ");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWords("  hello   world  ");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWords("th ");
        System.out.println("Reverse Words: "+reversed);

        System.out.println(" === Iterative === ");
        reversed = rw.reverseWordsIterative("the sky is blue");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative("  the    sky   is    blue  ");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative("  hello   world  ");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative("th ");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative("the");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative(" th");
        System.out.println("Reverse Words: "+reversed);

        reversed = rw.reverseWordsIterative(" th ");
        System.out.println("Reverse Words: "+reversed);
    }


}
