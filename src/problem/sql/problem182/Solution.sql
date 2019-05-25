-- 找出重复出现的邮箱地址
-- 解题思路：使用分组求个数

-- Write a SQL query to find all duplicate emails in a table named Person.
--
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- For example, your query should return the following for the above table:
--
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+

select Email
from Person
group by Email
having count(*) > 1;