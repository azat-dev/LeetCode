# Write your MySQL query statement below
SELECT 
    a_start.machine_id, 
    ROUND(
        SUM(a_end.timestamp - a_start.timestamp) / COUNT(DISTINCT a_start.process_id),
        3
    ) as processing_time
FROM Activity a_start
JOIN Activity a_end 
    ON a_start.machine_id = a_end.machine_id AND 
        a_start.process_id = a_end.process_id AND 
        a_start.activity_type = 'start' AND 
        a_end.activity_type = 'end'
GROUP BY machine_id