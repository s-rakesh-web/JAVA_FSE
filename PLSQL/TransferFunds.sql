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
            
               
            ELSE
            dbms_output.PUT_LINE('Sorry! you dont have sufficient amount to transfer');
            

            END IF;

        END IF;

        

    END LOOP;

    close account_cursor;


END;
/
BEGIN

    TransferFunds(1,2,5000);
END;
