package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/compare-version-numbers/description
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        int i  = 0;
        while( i < parts1.length || i < parts2.length) {
            int rev1 = 0;

            if( i < parts1.length) {
                String p1 = parts1[i];
                if(!"".equals(p1)) rev1 = Integer.parseInt(p1);
            }

            int rev2 = 0;
            if( i < parts2.length) {
                String p2 = parts2[i];
                if(!"".equals(p2)) rev2 = Integer.parseInt(p2);
            }

            if(rev1 < rev2) return -1;
            if(rev1 > rev2) return 1;

            i++;
        }

        return 0;
    }

}
