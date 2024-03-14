/* 3.Problem statement
 A pupil Tim gets homework to identify whether three line segments could possibly form a triangle.

 However, this assignment is very heavy because there are hundreds of records to calculate.

Could you help Tim by writing a query to judge whether these three  sides can form a triangle, assuming table triangle holds the length of the three sides x, y and z.

| x  | y  | z  |
|----|----|----|
| 13 | 15 | 30 |
| 10 | 20 | 15 |

 For the sample data above, your query should return the follow result:
 | x  | y  | z  | triangle |
 |----|----|----|----------|
 | 13 | 15 | 30 | No       |
 | 10 | 20 | 15 | Yes      | */ 

-- Create Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    low_fats CHAR(1),
    recyclable CHAR(1)
);

-- Insert data into Products table
INSERT INTO Products (product_id, low_fats, recyclable)
VALUES
    (0, 'Y', 'N'),
    (1, 'Y', 'Y'),
    (2, 'N', 'Y'),
    (3, 'Y', 'Y'),
    (4, 'N', 'N');
    
    -- querry 
    
    select product_id 
    from products 
    where low_fats='y' and recyclable ='y';
    
    
    