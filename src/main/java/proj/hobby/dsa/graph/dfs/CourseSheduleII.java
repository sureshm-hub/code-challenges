package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseSheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> preqMap = new HashMap<>();
        for(int [] preq : prerequisites) {
            preqMap.computeIfAbsent(preq[0], k -> new HashSet<>()).add(preq[1]);
        }

        List<Integer> order = new ArrayList<>();
        Set<Integer> done = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for(int i  = 0 ; i < numCourses; i++) {
            if(!canFinish(i, preqMap, visiting, done, order)) {
                return new int[0];
            }
        }

        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean canFinish(int course, Map<Integer, Set<Integer>> preqMap, Set<Integer> visiting, Set<Integer> done, List<Integer> order) {
        if(done.contains(course)) return true;
        if(visiting.contains(course)) return false;

        visiting.add(course);
        Set<Integer> preqs = preqMap.getOrDefault(course, new HashSet<>());
        for(int p : preqs) {
            if(!canFinish(p, preqMap, visiting, done, order)) return false;
        }
        done.add(course);
        visiting.remove(course);
        order.add(course);

        return true;
    }

}
