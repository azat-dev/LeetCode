-- Write your PostgreSQL query statement below
WITH HighSalaries AS (
    SELECT departmentId, MAX(salary) as salary
    FROM Employee
    GROUP BY departmentId
)
SELECT
    d.name as Department,
    e.name as Employee,
    h.salary as Salary
FROM Department as d
JOIN HighSalaries as h ON d.id = h.departmentId
JOIN Employee as e ON e.salary = h.salary AND e.departmentId = d.id