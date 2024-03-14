/*  4.Problem statement
Table: Friends

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| name          | varchar |
| activity      | varchar |
+---------------+---------+
id is the id of the friend and primary key for this table.
name is the name of the friend.
activity is the name of the activity which the friend takes part in.
Table: Activities

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| name          | varchar |
+---------------+---------+
id is the primary key for this table.
name is the name of the activity.


Write an SQL query to find the names of all the activities with neither maximum, nor minimum number of participants.

Return the result table in any order. Each activity in table Activities is performed by any person in the table Friends.

The query result format is in the following example:

Friends table:
+------+--------------+---------------+
| id   | name         | activity      |
+------+--------------+---------------+
| 1    | Jonathan D.  | Eating        |
| 2    | Jade W.      | Singing       |
| 3    | Victor J.    | Singing       |
| 4    | Elvis Q.     | Eating        |
| 5    | Daniel A.    | Eating        |
| 6    | Bob B.       | Horse Riding  |
+------+--------------+---------------+

Activities table:
+------+--------------+
| id   | name         |
+------+--------------+
| 1    | Eating       |
| 2    | Singing      |
| 3    | Horse Riding |
+------+--------------+

Result table:
+--------------+
| activity     |
+--------------+
| Singing      |
+--------------+

Eating activity is performed by 3 friends, maximum number of participants, (Jonathan D. , Elvis Q. and Daniel A.)
Horse Riding activity is performed by 1 friend, minimum number of participants, (Bob B.)
Singing is performed by 2 friends (Victor J. and Jade W.) */


-- Create Friends table
CREATE TABLE Friends (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    activity VARCHAR(50)
);

-- Insert data into Friends table
INSERT INTO Friends (id, name, activity)
VALUES
    (1, 'Jonathan D.', 'Eating'),
    (2, 'Jade W.', 'Singing'),
    (3, 'Victor J.', 'Singing'),
    (4, 'Elvis Q.', 'Eating'),
    (5, 'Daniel A.', 'Eating'),
    (6, 'Bob B.', 'Horse Riding');
    
    
    -- Create Activities table
CREATE TABLE Activities (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Insert data into Activities table
INSERT INTO Activities (id, name)
VALUES
    (1, 'Eating'),
    (2, 'Singing'),
    (3, 'Horse Riding');
    

   


SELECT activity
FROM Friends
GROUP BY activity
HAVING COUNT(activity) <> (
    SELECT COUNT(activity) FROM Friends GROUP BY activity ORDER BY COUNT(activity) DESC LIMIT 1
) AND COUNT(activity) <> (
    SELECT COUNT(activity) FROM Friends GROUP BY activity ORDER BY COUNT(activity) ASC LIMIT 1
);

-- using with
WITH ActivityCounts AS (
    SELECT activity, COUNT(*) AS count_activity
    FROM Friends
    GROUP BY activity
)
SELECT activity
FROM ActivityCounts
WHERE count_activity <> (
    SELECT MAX(count_activity) FROM ActivityCounts
) AND count_activity <> (
    SELECT MIN(count_activity) FROM ActivityCounts
);

WITH ActivityCounts AS (
    SELECT activity, COUNT(*) AS count_activity
    FROM Friends
    GROUP BY activity
)
SELECT activity
FROM ActivityCounts
WHERE count_activity not in (select max(count_activity) from ActivityCounts union select min(count_activity) from ActivityCounts);
   




    
    
    

