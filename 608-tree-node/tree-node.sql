# Write your MySQL query statement below
WITH Children AS (
    SELECT p_id, COUNT(DISTINCT id) as number_of_children
    FROM Tree
    GROUP BY p_id
)
SELECT
    id,
    CASE
        WHEN Tree.p_id IS NULL THEN 'Root'
        WHEN number_of_children IS NULL OR number_of_children = 0 THEN 'Leaf'
        ELSE 'Inner'
    END as Type
FROM Tree
LEFT JOIN Children ON Children.p_id = Tree.id