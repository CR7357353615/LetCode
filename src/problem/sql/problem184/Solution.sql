-- 找出每个部门工资最高的人

-- 解题思路：先使用group by将每个部门最高工资数找出来，然后与志愿表连接，部门和工资都相等的是结果

-- The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 70000  | 1            |
-- | 2  | Jim   | 90000  | 1            |
-- | 3  | Henry | 80000  | 2            |
-- | 4  | Sam   | 60000  | 2            |
-- | 5  | Max   | 90000  | 1            |
-- +----+-------+--------+--------------+
-- The N table holds all departments of the company.
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, your SQL query should return the following rows (order of rows does not matter).
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Jim      | 90000  |
-- | Sales      | Henry    | 80000  |
-- +------------+----------+--------+

SELECT dpt.Department,e.Name as Employee,dpt.Salary
from
(
/* First get the highest salary for each department */
Select d.Name as Department,d.Id,Max(Salary) as Salary
FROM Employee e
Left JOIN Department d
on e.DepartmentID=d.Id
group by d.Name,d.Id
)dpt
left JOIN Employee e
On dpt.Id=e.DepartmentId
and dpt.Salary=e.Salary
where dpt.Id is not null