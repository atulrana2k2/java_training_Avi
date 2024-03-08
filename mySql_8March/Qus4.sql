create table StudentScore(
ID int,
Score float);

Insert into StudentScore values
(1, 70.25),
(2, 73.50),
(3, 80.75),
(4, 77.80),
(5, 80.00),
(6, 73.25),
(7, 80.00),
(8, 70.25),
(9, 80.75),
(10, 73.50);

select * from studentscore;

select s1.Score, (select count(distinct s2.Score) from studentscore s2 
where s2.score >= s1.score) as 'rank' from studentscore s1 order by s1.score desc;