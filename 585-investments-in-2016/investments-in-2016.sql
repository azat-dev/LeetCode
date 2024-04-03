# Write your MySQL query statement below
SELECT
    ROUND(SUM(tiv_2016), 2) as tiv_2016
FROM Insurance ia
WHERE (ia.lat, ia.lon) NOT IN (
    SELECT ib.lat, ib.lon
    FROM Insurance ib 
    WHERE ia.pid != ib.pid
) AND tiv_2015 = (
    SELECT tiv_2015 
    FROM Insurance ic
    WHERE ia.pid != ic.pid AND ic.tiv_2015 = ia.tiv_2015
    LIMIT 1
)