# Write your MySQL query statement below
SELECT id, COUNT(id) as num
FROM (
    SELECT requester_id as id FROM RequestAccepted
    UNION ALL
    SELECT accepter_id as id FROM RequestAccepted
) AS ids
GROUP BY id
ORDER BY COUNT(id) DESC
LIMIT 1