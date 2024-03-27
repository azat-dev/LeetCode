SELECT
    emp.name Employee
FROM Employee emp
    JOIN Employee mng 
        ON emp.managerId = mng.id
WHERE
    emp.salary > mng.salary