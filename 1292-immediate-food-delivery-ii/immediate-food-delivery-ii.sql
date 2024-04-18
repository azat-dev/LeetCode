# Write your MySQL query statement below
WITH FirstOrdersDatesByCustomers AS (
    SELECT customer_id, MIN(order_date) as order_date
    FROM Delivery
    GROUP BY customer_id
)
SELECT
    ROUND(
        100 *
        AVG(
            CASE 
                WHEN d.order_date = d.customer_pref_delivery_date THEN 1
                ELSE 0
            END
        ),
        2
    ) as immediate_percentage
FROM Delivery d
JOIN FirstOrdersDatesByCustomers f ON d.customer_id = f.customer_id 
    AND d.order_date = f.order_date