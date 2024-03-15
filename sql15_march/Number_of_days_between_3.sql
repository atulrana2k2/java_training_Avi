--  Create Table
CREATE TABLE job_history (
    employee_id    INT,
    start_date     DATE,
    end_date       DATE,
    job_id         VARCHAR(20),
    department_id  INT
);

--  Insert Data
INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id) VALUES
(102, '1993-01-13', '1998-07-24', 'IT_PROG', 60),
(101, '1989-09-21', '1993-10-27', 'AC_ACCOUNT', 110),
(101, '1993-10-28', '1997-03-15', 'AC_MGR', 110),
(201, '1996-02-17', '1999-12-19', 'MK_REP', 20),
(114, '1998-03-24', '1999-12-31', 'ST_CLERK', 50),
(122, '1999-01-01', '1999-12-31', 'ST_CLERK', 50),
(200, '1987-09-17', '1993-06-17', 'AD_ASST', 90),
(176, '1998-03-24', '1998-12-31', 'SA_REP', 80),
(176, '1999-01-01', '1999-12-31', 'SA_MAN', 80),
(200, '1994-07-01', '1998-12-31', 'AC_ACCOUNT', 90);

-- querry
select jh.employee_id,j.job_title,datediff(jh.end_date,jh.start_date)as days
from job_history jh
join jobs j
on jh.job_id=j.job_id
where jh.department_id=90;
