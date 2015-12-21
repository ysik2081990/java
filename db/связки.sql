select * from employees emp, events ev, nameofsubject nam, priceofsubject price
where emp.id = ev.employee_id_fk
and emp.id = nam.id
and nam.id = price.id