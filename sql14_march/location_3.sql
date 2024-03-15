with result as(
select d.department_id from departments d
join locations l
on d.location_id = l.location_id
where l.city='london'
)
select  e.first_name,e.last_name,e.job_id,r.department_id
from employees e
join result r
on e.department_id=r.department_id;

select  e.first_name,e.last_name,e.job_id,d.department_id
from employees e
join departments d
on e.department_id=d.department_id
join locations l
on d.location_id = l.location_id
where l.city='london';

