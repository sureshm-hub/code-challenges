package proj.hobby.dsa.strings;

import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/remove-zeros-in-decimal-representation/
 *
 */
public class RemoveZeros {

    public long removeZeros(long n) {
        // method 1:
        // String s = Long.toString(n);
        // StringBuilder sb = new StringBuilder();
        // for(char c : s.toCharArray()) {
        //     if(c != '0') sb.append(c);
        // }
        // return Long.parseLong(sb.toString());

        // method 2:
        // StringBuilder sb = Long.toString(n).chars().mapToObj(x -> (char) x)
        //             .filter(x -> x != '0')
        //             .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // return Long.parseLong(sb.toString());

        // method 3:
        String rslt = Long.toString(n).chars().mapToObj(x -> (char) x)
                .filter( x -> x != '0')
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        return Long.parseLong(rslt);
    }

}
