-- tbale Department, Employees are already created

select d.Department_id,d.department_name,d.manager_id,e.first_name
from departments d
join employees e
on d.manager_id =e.EMPLOYEE_ID
order by d.department_id;