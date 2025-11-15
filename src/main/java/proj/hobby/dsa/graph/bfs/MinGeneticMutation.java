package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 */
public class MinGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if(!bankSet.contains(endGene)) return -1;

        final char[] GENES = new char[]{'A', 'C', 'G', 'T'};

        Queue<String> path = new ArrayDeque<>(List.of(startGene));

        for(int step = 1; !path.isEmpty(); ++step) {
            for(int sz = path.size(); sz > 0; sz--){
                StringBuilder sb  = new StringBuilder(path.poll());
                for(int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    for(char g : GENES) {
                        sb.setCharAt(j, g);
                        String next = sb.toString();
                        if(next.equals(endGene)) return step;
                        if(bankSet.contains(next)) {
                            bankSet.remove(next);
                            path.offer(next);
                        }
                    }
                    sb.setCharAt(j, c); //backtrack
                }
            }
        }

        return -1;
    }
}
