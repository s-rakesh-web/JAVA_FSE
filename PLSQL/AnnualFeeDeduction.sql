DECLARE
v_id NUMBER;
v_name varchar2(30);
v_balance NUMBER;
v_fee NUMBER :=500;  -- Annual Deduction Fees


CURSOR ApplyAnnualFee IS SELECT  CustomerId,Name From
Customers;

BEGIN

    Open ApplyAnnualFee;
LOOP
    Fetch ApplyAnnualFee into v_id,v_name;
    exit when ApplyAnnualFee%notfound;

    Update Customers
    SET Balance=Balance-v_fee,
    LastModified=SYSDATE
    WHERE CustomerID=v_id;

    Select Balance into v_balance From Customers WHERE CustomerID=v_id;
    dbms_output.put_line(v_name||' We deducted '||v_fee||' from your account as annual maintainance fee ');
    dbms_output.put_line('Current Balance: '||v_balance);

END LOOP;

END;
