package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {

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


    /**
     *
     * NOTE: DFS Anti pattern
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        // if(numCourses == 1) return new int[] {0}; // NOTE: iterate from 0 to numCourses per description "0 to numCourses - 1"
        Map<Integer, Set<Integer>> preqMap = new HashMap<>();
        for(int[] course : prerequisites) {
            preqMap.computeIfAbsent(course[0], k -> new HashSet<>()).add(course[1]);
        }

        List<Integer> courseOrder = new ArrayList<>();
        // for(int[] course : prerequisites) {
        //     if(!canOrder(course[0], preqMap, new HashSet<>(), new HashSet<>(), courseOrder)) { // NOTE: new visiting & scheduled for each course will cause course duplicates
        //         return new int[] {};
        //     }
        // }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> scheduled = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!canFinish(i, preqMap, visiting, scheduled, courseOrder)) {
                return new int[0];
            }
        }
        return courseOrder.stream().mapToInt(Integer::intValue).toArray();
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
