-- Write your PostgreSQL query statement below
WITH Ranks AS (
    SELECT
        score,
        RANK() OVER (ORDER BY score DESC) as rank
    FROM Scores
    GROUP BY score
)
SELECT 
    s.score as score,
    rank
FROM Scores AS s
JOIN Ranks AS r ON s.score = r.score
ORDER BY s.score DESC