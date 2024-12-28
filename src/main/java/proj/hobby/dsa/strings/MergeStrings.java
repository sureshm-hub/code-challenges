package proj.hobby.dsa.strings;

public class MergeStrings {

    public String mergeAlternately(String word1, String word2) {

        if (word1 == null) return word2;
        if (word2 == null) return word1;

        int i1 = 0, i2 = 0;
        StringBuilder sb = new StringBuilder();
        while(i1 < word1.length() && i2 < word2.length()) {
            sb.append(word1.charAt(i1++));
            sb.append(word2.charAt(i2++));
        }

        while(i1 < word1.length()) {
            sb.append(word1.charAt(i1++));
        }

        while(i2 < word2.length()) {
            sb.append(word2.charAt(i2++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStrings ms = new MergeStrings();
        System.out.println(ms.mergeAlternately("abc","def"));
        System.out.println(ms.mergeAlternately("abc","d"));
        System.out.println(ms.mergeAlternately("a","def"));
        System.out.println(ms.mergeAlternately("",""));
        System.out.println(ms.mergeAlternately("","def"));
        System.out.println(ms.mergeAlternately("a",""));
    }

}
