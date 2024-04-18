# Write your MySQL query statement below
SELECT
    activity_date day,
    COUNT(DISTINCT user_id) active_users
FROM Activity
WHERE activity_date <= '2019-07-27' AND activity_date > DATE_SUB('2019-07-27', interval 30 day)
GROUP BY activity_date