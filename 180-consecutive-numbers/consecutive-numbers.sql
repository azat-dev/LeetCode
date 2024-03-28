-- Write your PostgreSQL query statement below
WITH Groups AS(
    SELECT
        id,
        num,
        ROW_NUMBER() OVER (ORDER BY id) - ROW_NUMBER() OVER (PARTITION BY num ORDER BY id) as groupId
    FROM Logs
    order by id
)
SELECT DISTINCT
    num as ConsecutiveNums
FROM Groups
GROUP BY num, groupId
HAVING COUNT(id) >= 3