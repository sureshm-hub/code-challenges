package proj.hobby.dsa.twopointer;

/**
 * https://leetcode.com/problems/gas-station
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int total = 0, tank = 0, start = 0;

        for(int i  = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ?start : -1;
    }

}
