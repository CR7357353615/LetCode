-- 计算第二高的工资
-- Write a SQL query to get the second highest salary from the Employee table.
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
--
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+

select
case
    when count(distinct Salary) >= 2 then (select Salary from Employee order by Salary DESC limit 1, 1)
    else NULL
end as SecondHighestSalary
from Employee
