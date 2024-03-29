-- Write your PostgreSQL query statement below
WITH Total AS (
    SELECT COUNT(DISTINCT player_id) as totalCount
    FROM Activity
), FirstDatesForPlayers AS (
    SELECT player_id, MIN(event_date) as first_date
    FROM Activity
    GROUP BY player_id
)
, PlayersLoggedInAgain AS (
    SELECT COUNT(DISTINCT f.player_id) as playersLoggedInAgainCount
    FROM FirstDatesForPlayers f
        INNER JOIN Activity a ON f.player_id = a.player_id AND
            (first_date + 1) = a.event_date
)
SELECT 
    ROUND(playersLoggedInAgainCount * 1.0 / totalCount, 2) as fraction
FROM PlayersLoggedInAgain, Total