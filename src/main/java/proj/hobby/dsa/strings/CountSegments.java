package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 */
public class CountSegments {

    public int countSegments(String s) {

        int segs = 0;

        for(int i = 0; i < s.length(); i++) {
            boolean isNonSpace = !Character.isSpace(s.charAt(i));

            // first segment starts with <non-space>
            if(i == 0 && isNonSpace) segs++;

            // all other segments have space<non-space> pattern
            if(i != 0 && isNonSpace && Character.isSpace(s.charAt(i - 1))) segs++;
        }

        return segs;
    }
}
