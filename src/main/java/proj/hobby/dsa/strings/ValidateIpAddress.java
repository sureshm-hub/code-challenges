package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/validate-ip-address
 *
 */
public class ValidateIpAddress {

    private static final String NEITHER = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";

    public String validIPAddress(String queryIP) {

        if(queryIP.chars().filter(c -> c == '.').count() == 3) {

            // check IPv4
            String[] splits = queryIP.split("\\.");

            if(splits.length != 4) return NEITHER;

            int i = 0;
            while(i < 4) {
                String part = splits[i];
                if(part.length() == 0 || part.length() > 3) return NEITHER;

                if(part.length() > 1 && part.charAt(0) == '0')  return NEITHER;

                for(char c : part.toCharArray()) {
                    if(!Character.isDigit(c)) return NEITHER;
                }

                int val = Integer.parseInt(part);
                if(val > 255) return NEITHER;
                i++;
            }
            return IPV4;
        } else if(queryIP.chars().filter(c -> c == ':').count() == 7) {
            //check IPv6
            String[] splits = queryIP.split(":");
            if(splits.length != 8) return NEITHER;

            int i = 0;
            while(i < 8) {

                String part = splits[i];
                if(part.length() == 0 || part.length() > 4) return NEITHER;

                for(char c : part.toCharArray()) {
                    if(!(Character.isDigit(c) || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) return NEITHER;
                }
                i++;
            }
            return IPV6;
        }
        System.out.println(" >> last");
        return NEITHER;
    }
}
