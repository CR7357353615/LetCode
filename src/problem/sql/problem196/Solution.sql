-- 删除重复的邮箱数据，只保留Id最小的
-- 解题思路：使用group by，搭配not in

-- Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id is the primary key column for this table.
-- For example, after running your query, the above Person table should have the following rows:
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- Note:
--
-- Your output is the whole Person table after executing your sql. Use delete statement.

DELETE FROM Person WHERE Id not in
(
  select Id from (
		select min(p1.Id) Id from Person p1 GROUP BY Email
	) p2
);