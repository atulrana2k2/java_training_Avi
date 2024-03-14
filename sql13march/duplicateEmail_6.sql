 /* 6.Problem statement
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+ */



-- Create the table
CREATE TABLE emails (
    Id INT,
    Email VARCHAR(50)
);

-- Insert the data
INSERT INTO emails (Id, Email) VALUES
    (1, 'a@b.com'),
    (2, 'c@d.com'),
    (3, 'a@b.com'),
    (4, 'e@f.com'),
    (5, 'g@h.com'),
    (6, 'c@d.com'),
    (7, 'i@j.com'),
    (8, 'a@b.com'),
    (9, 'k@l.com'),
    (10, 'm@n.com');
    
    select email
    from emails
    group by email
    having count(email)>1;

