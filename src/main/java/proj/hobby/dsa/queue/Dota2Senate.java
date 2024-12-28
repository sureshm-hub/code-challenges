package proj.hobby.dsa.queue;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: LinkedList Deque
 *
 * Complexity:
 *  Time: O(N*m) - m is the number of rounds
 *  Space: O(N)
 *
 */
public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Deque<Integer> dires = new LinkedList<>();
        Deque<Integer> rads = new LinkedList<>();
        int length = senate.length();
        // create Queue for rads and dires
        for(int i = 0 ; i < length; i++) {
            if(senate.charAt(i) == 'R') {
                rads.add(i);
            } else {
                dires.add(i);
            }
        }

        // Banning round
        while(!rads.isEmpty() && !dires.isEmpty()) {
            int direRank =  dires.removeFirst();
            int radRank = rads.removeFirst();
            if(direRank < radRank) {
                dires.add(direRank+length);
            } else {
                rads.add(radRank+length);
            }
        }

        // Anouncing Victory Round
        return rads.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate senate = new Dota2Senate();
        System.out.println("Dota2Senate Victory: "+senate.predictPartyVictory("RD"));
        System.out.println("Dota2Senate Victory: "+senate.predictPartyVictory("RDD"));
        System.out.println("Dota2Senate Victory: "+senate.predictPartyVictory("RDDRRRDDDDDDD"));
        System.out.println("Dota2Senate Victory: "+senate.predictPartyVictory("RRRRRR"));
        System.out.println("Dota2Senate Victory: "+senate.predictPartyVictory("R".repeat(1000)+"D".repeat(1000)));
    }

}
