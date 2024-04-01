# Write your MySQL query statement below
SELECT
    Seat.id as id,
    CASE
        WHEN Seat.id % 2 = 0 THEN (SELECT student FROM Seat as s2 WHERE s2.id = Seat.id - 1)
        ELSE COALESCE(
            (SELECT student FROM Seat as s2 WHERE s2.id = Seat.id + 1),
            Seat.student
        )
    END as student
FROM Seat
    LEFT JOIN Seat as NextSeat ON Seat.id = NextSeat.id - 1
