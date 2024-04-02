-- Write your PostgreSQL query statement below
SELECT w.id as Id
FROM Weather w
WHERE w.temperature > (SELECT temperature FROM Weather pw WHERE pw.recordDate = w.recordDate - 1)