CREATE OR REPLACE PROCEDURE UpdateSalary(
    Id IN NUMBER,
    percent IN NUMBER
)
IS

p_decimal NUMBER;
p_result NUMBER;
Original_salary NUMBER;

--Final Value=Original Salary * (1+Percentage as a decimal)
--Formula to increase salary by percentage

BEGIN

    Select Salary into Original_salary From Employees where Id=EmployeeId;

    p_decimal:=percent/100;
    p_result:=Original_salary*(1+p_decimal);

    UPDATE EMPLOYEES
    SET SALARY=p_result
    Where EmployeeID=Id;

EXCEPTION

When NO_DATA_FOUND THEN
dbms_output.PUT_LINE('Given EmployeeID does not exist');

END;
/
BEGIN
    UpdateSalary(5,500);
END;
