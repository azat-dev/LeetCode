WITH SalaryRanks AS (
    SELECT DISTINCT *
    FROM (
        SELECT
            departmentId,
            salary,
            DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) as rank
        FROM Employee
    )
    WHERE rank <= 3
)
SELECT DISTINCT
    d.name as Department,
    e.name as Employee,
    sr.salary as Salary
FROM SalaryRanks as sr
JOIN Employee as e ON sr.departmentId = e.departmentId AND sr.salary = e.salary
JOIN Department as d ON d.id = sr.departmentId