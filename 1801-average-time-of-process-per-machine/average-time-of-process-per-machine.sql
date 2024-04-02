# Write your MySQL query statement below
SELECT 
    machine_id, 
    ROUND(
        AVG(
            CASE 
                WHEN a.activity_type = 'end' THEN a.timestamp
                ELSE -a.timestamp
            END
        ) * 2,
        3
    ) as processing_time
FROM Activity a
GROUP BY machine_id