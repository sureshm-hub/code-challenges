package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/count-and-say/description/
 */
public class CountAndSay {

    public String countAndSay(int n) {

        String rle = "1";
        for(int i = 2; i <= n; i++) {
            StringBuilder say = new StringBuilder();
            char num = rle.charAt(0);
            int counter = 1;

            for(int k =1; k < rle.length(); k++) {
                if(rle.charAt(k) == num) {
                    counter++;
                }  else {
                    say.append(counter).append(num);
                    num = rle.charAt(k);
                    counter = 1;
                }
            }
            say.append(counter).append(num);
            rle = say.toString();
        }
        return rle;

    }
}
