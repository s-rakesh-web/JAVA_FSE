CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id IN NUMBER,
    p_Name IN VARCHAR2,--we should not give size in parameter
    p_dob IN DATE,
    p_balance IN NUMBER

)
IS

BEGIN
    Insert INTO Customers(CustomerId,Name,Dob,Balance,LastModified)
    Values(
        p_id,
        p_name,
        p_dob,
        p_balance,
        SYSDATE
    );

    dbms_output.put_line('New Customer Added');
EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN -- Used when private id is duplicated
dbms_output.put_line('Given customer ID already exist');


END;
/

BEGIN
    AddNewCustomer(1,'ROCKY','05-APR-2006',10000);
END;
