CREATE OR REPLACE FUNCTION HasSufficientBalance(
    AccountID IN NUMBER,
    Amount IN NUMBER
)
return BOOLEAN
IS
v_id NUMBER;
v_balance NUMBER;
isSufficient BOOLEAN;

CURSOR account_cursor IS Select AccountID,Balance From Accounts;

BEGIN

    Open account_cursor;
Loop
    Fetch account_cursor into v_id,v_balance;
    exit when account_cursor%notfound;

    IF AccountID=v_id then
        IF Amount <=v_balance then
            isSufficient:=TRUE;

        ELSE
            isSufficient:=FALSE;

        END IF;
    
    END IF;

END LOOP;
Close account_cursor;
return isSufficient;

END;
/
DECLARE
checking BOOLEAN;

BEGIN
    checking:=HasSufficientBalance(1,500);

    IF checking=TRUE then
    dbms_output.put_line('The account have sufficient amount');

    ELSE
    dbms_output.put_line('The account does not have sufficient amount');

    END IF;

END;
