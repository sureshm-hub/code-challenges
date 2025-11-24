package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/license-key-formatting/description
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int count = k;
        int r = s.length() - 1;
        int l = 0;
        while(s.charAt(l) == '-' && l < r) l++; // trim end
        while(s.charAt(r) == '-' && l < r) r--; // trim start

        for(int i = r; i >= l; i--) {
            char c = s.charAt(i);
            if(c == '-') continue;
            count--;
            sb.append(Character.toUpperCase(c));
            if(count == 0 && i != l) {
                count = k;//reset
                sb.append("-");
            }
        }
        return sb.reverse().toString();

    }
}
