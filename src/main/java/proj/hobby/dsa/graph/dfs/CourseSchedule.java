package proj.hobby.dsa.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> preqs = new HashMap<>();
        for(int[] p : prerequisites) {
            Set<Integer> preqCourses = preqs.getOrDefault(p[0], new HashSet<>());
            preqCourses.add(p[1]);
            preqs.put(p[0], preqCourses);
        }

        for(int[] p : prerequisites) {
            if(!canFinish(p[0], preqs, new HashSet<>(), new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int course, Map<Integer, Set<Integer>> preqMap, Set<Integer> visiting, Set<Integer> done) {
        if(done.contains(course)) return true;
        if(visiting.contains(course)) return false;

        visiting.add(course);
        Set<Integer> preqCourses = preqMap.getOrDefault(course, new HashSet<>());
        for(int pre: preqCourses) {
            if(!canFinish(pre, preqMap, visiting, done)) return false;
        }
        visiting.remove(course);
        done.add(course);
        return true;
    }
}
