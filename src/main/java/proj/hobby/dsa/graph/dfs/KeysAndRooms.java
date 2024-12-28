package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Graph BFS
 *
 * Complexity:
 *  Time: O(N) - N is number of Rooms
 *  Space: O(N) -  to keep track of visited rooms
 *
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> pending = new LinkedList<>(); // rooms we are pending visit based on prior rooms
        pending.addAll(rooms.get(0));
        visited.add(0);// track visit to room 0
        while(!pending.isEmpty()) {
            Integer next = pending.poll();
            if(!visited.contains(next)) { // check if we haven't visited this room already
                visited.add(next);// keep track of visited rooms
                pending.addAll(rooms.get(next));
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        KeysAndRooms keys = new KeysAndRooms();
        System.out.println("all visited: "+keys.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        System.out.println("all visited: "+keys.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0))));
    }

}
