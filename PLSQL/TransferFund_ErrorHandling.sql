CREATE OR REPLACE PROCEDURE TransferFunds(FromID IN NUMBER,ToID IN NUMBER,AMOUNT IN NUMBER)
IS

c_id Accounts.AccountId%TYPE;
c_balance Accounts.Balance%TYPE;
v_receiver_balance NUMBER;
CURSOR account_cursor IS SELECT AccountID,Balance FROM Accounts;

BEGIN
    OPEN account_cursor;

    LOOP
        Fetch account_cursor into c_id,c_balance;
        exit when account_cursor%notfound;

        IF FromID=c_id then

            IF c_balance>Amount then

                UPDATE Accounts
                SET Balance=Balance-Amount
                WHERE AccountId=FromID;
        
                dbms_output.PUT_LINE('HEY! You sent '||Amount||' to the account ID'
                ||ToID);

            
                UPDATE Accounts
                SET Balance=Balance+Amount
                WHERE AccountId=ToID;

                Select Balance INTO v_receiver_balance
                from Accounts
                WHERE AccountId=ToID;

                

                dbms_output.PUT_LINE('HEY! You recieved '||Amount||' From AccountID '
                ||FromID||chr(10)||'Now the account Balance:'||v_receiver_balance);
            
                COMMIT;
                
            ELSE
            RAISE_APPLICATION_ERROR(-20001,'Sorry! you dont have sufficient amount to transfer');
            

            END IF;

        END IF;

        

    END LOOP;

    close account_cursor;

EXCEPTION

WHEN NO_DATA_FOUND THEN
ROLLBACK;
dbms_output.put_line('ERROR: Account not found');

WHEN INVALID_NUMBER THEN
ROLLBACK;
dbms_output.put_line('ERROR: Invalid Amount Entered');

When Others THEN
ROLLBACK;
dbms_output.put_line('ERROR: '||SQLERRM);

END;
/


CREATE OR REPLACE TRIGGER update_account
AFTER UPDATE ON Accounts 
FOR EACH ROW

Begin 
    
    

    UPDATE Customers 
    SET Balance=:NEW.Balance,
    LastModified=SYSDATE
    WHERE CustomerId=:NEW.CustomerID;





END;
/
    
BEGIN

    TransferFunds(2,1,10000);
END;


