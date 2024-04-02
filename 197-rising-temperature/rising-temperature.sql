-- Write your PostgreSQL query statement below
SELECT w.id as Id
FROM Weather w
JOIN Weather pw ON w.recordDate - 1 = pw.recordDate
WHERE w.temperature > pw.temperature