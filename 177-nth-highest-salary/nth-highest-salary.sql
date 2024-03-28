CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
        SELECT COALESCE(
            CASE 
                WHEN N > 0 THEN
                    (SELECT e.salary as Salary
                    FROM Employee as e
                    GROUP BY e.salary 
                    ORDER BY e.salary DESC 
                    LIMIT 1 OFFSET (N - 1))
                ELSE
                    NULL
            END
        , NULL)
      
  );
END;
$$ LANGUAGE plpgsql;