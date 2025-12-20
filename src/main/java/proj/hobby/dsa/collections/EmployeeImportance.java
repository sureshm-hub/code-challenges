package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/employee-importance
 *
 */
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> empMap = new HashMap<>();
        for(Employee emp: employees) {
            empMap.put(emp.id, emp);
        }

        int imp = 0;
        Deque<Employee> q = new ArrayDeque<>();
        q.offer(empMap.get(id));
        while(!q.isEmpty()) {
            Employee cur = q.poll();
            imp += cur.importance;
            for(int i : cur.subordinates) {
                q.offer(empMap.get(i));
            }
        }
        return imp;
    }

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
