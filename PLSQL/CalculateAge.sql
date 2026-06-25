CREATE OR REPLACE FUNCTION CalculateAge(DOB IN DATE)
return NUMBER
IS
v_age NUMBER;

BEGIN

    v_age:=TRUNC(Months_between(SYSDATE,DOB)/12);

    return v_age;


END;
/
DECLARE
v_age NUMBER;

BEGIN
    v_age:=CalculateAge('21-Apr-2006');
    dbms_output.PUT_LINE('Your age is : '||v_age);

END;
