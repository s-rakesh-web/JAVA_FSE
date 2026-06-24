
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(Bonus IN NUMBER,p_Department IN VARCHAR2)
IS/*
v_name Employees.Name%TYPE;
v_department Employees.Department%TYPE;
v_salary Employees.Salary%TYPE;
*/
v_name       VARCHAR2(100);
v_salary     NUMBER;
v_department VARCHAR2(50);


cursor employee_cursor is select Name,Salary,Department from Employees;
BEGIN

    OPEN employee_cursor;
Loop
    Fetch employee_cursor into v_name,v_salary,v_department;
    exit when employee_cursor%notfound;
    if p_Department=v_department then
    UPDATE Employees
    set Salary=Salary+Bonus
    where Department=v_department;

    dbms_output.put_line('Hey! '||v_name||' from '||v_department||' you got bonus  '
    ||(v_salary+Bonus));

    else 
    dbms_output.put_line('Sorry! '||v_name||' from '||v_department||' you got no bonus  '
    ||v_salary);
    end if;
end loop;
close employee_cursor;
end UpdateEmployeeBonus;
/
begin
    UpdateEmployeeBonus(5000,'IT');
end;
