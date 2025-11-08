package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/utf-8-validation/description/
 *
 */
public class UTF8Validation {

    public boolean validUtf8(int[] data) {

        if (data == null || data.length == 0) return false;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 255) return false;// 1 after 8th bit
            int bytes = 0;
            int d = data[i];
            if ((d & 128) == 0) {          // mask: 1000 0000
                continue;// 1 byte
            } else if ((d & 224) == 192) {  // mask: 1110 0000
                bytes = 1;
            } else if ((d & 240) == 224) { // mask: 1111 0000
                bytes = 2;
            } else if ((d & 248) == 240) {  // mask: 1111 1000
                bytes = 3;
            } else {
                return false;
            }

            if (i + bytes >= data.length) return false;

            for (int j = 1; j <= bytes; j++) {
                ++i;
                if (data[i] >= 192 || data[i] < 128) return false;
            }

        }

        return true;
    }
}
