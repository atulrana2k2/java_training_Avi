select a.employee_id , a.last_name , a.manager_id,b.last_name
from employees a
join  employees b
on  a.manager_id=b.employee_id order by a.EMPLOYEE_ID;