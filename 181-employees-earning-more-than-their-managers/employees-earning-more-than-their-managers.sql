SELECT
    emp.name Employee
FROM Employee emp
    LEFT JOIN Employee mng 
        ON emp.managerId = mng.id
WHERE
    emp.salary > mng.salary