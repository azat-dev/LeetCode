WITH CustomersWithOrderCounts AS (
    SELECT customer_number, COUNT(*) as count
    FROM Orders 
    GROUP BY customer_number
)
SELECT
    customer_number
FROM CustomersWithOrderCounts
WHERE count = (SELECT MAX(count) FROM CustomersWithOrderCounts)