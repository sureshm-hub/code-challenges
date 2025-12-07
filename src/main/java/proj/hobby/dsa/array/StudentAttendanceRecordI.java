package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/student-attendance-record-i
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int abs = 0;
        int late = 0;
        for(char c : s.toCharArray()) {
            // check for absence
            if(c == 'A') abs++;
            if(abs == 2) return false;

            // check for continuous late
            if(c == 'L') {
                late++;
            } else {
                late = 0;// reset late;
            }
            if(late == 3) return false;
        }
        return true;
    }
}
