# Write your MySQL query statement below
SELECT
    Seat.id as id,
    CASE
        WHEN Seat.id % 2 = 0 THEN PrevSeat.student
        WHEN NextSeat.id IS NULL THEN Seat.student
        ELSE NextSeat.student
    END as student
FROM Seat
    LEFT JOIN Seat as NextSeat ON Seat.id = NextSeat.id - 1
    LEFT JOIN Seat as PrevSeat ON Seat.id = PrevSeat.id + 1
