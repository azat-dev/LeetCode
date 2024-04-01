# Write your MySQL query statement below
SELECT
    id,
    CASE
        WHEN is_even THEN prev_student
        WHEN next_student IS NULL THEN student
        ELSE next_student
    END as student
FROM (
    SELECT
        id,
        student,
        LAG(student, 1) OVER (ORDER BY id) as prev_student,
        LEAD(student, 1) OVER (ORDER BY id) as next_student,
        (RANK() OVER (ORDER BY id)) % 2 = 0 as is_even
    FROM Seat
) AS SeatsWithAdditionalInfo
