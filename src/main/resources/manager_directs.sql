# Problem
https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/

# Write your MySQL query statement below
select manager.name from Employee manager where manager.id in (
    With managerWith5Employees as (
        select
            manager.id as managerId, count(1) as directReportCount
        from
            Employee manager left outer join  Employee emp on manager.id = emp.managerId
        group by
            manager.id
        having
            directReportCount >= 5
    ) select managerId from managerWith5Employees
)