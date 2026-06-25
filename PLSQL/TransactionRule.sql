CREATE OR REPLACE TRIGGER CheckTransactionRules 
BEFORE INSERT ON Transactions 
FOR EACH ROW
DECLARE
v_balance NUMBER;

BEGIN

    select Balance into v_balance From accounts
    where :NEW.AccountId=AccountId;

    if :NEW.TransactionType='Deposit' THEN
        IF (:NEW.Amount<=0) THEN
        RAISE_APPLICATION_ERROR(-20001,'Transaction amount should not be Negative');


        ELSE
        Update Accounts
        SET Balance=Balance+:NEW.Amount
        Where :new.AccountID=AccountID;

        END IF;

    END IF;

    IF :NEW.TransactionType='Withdrawl' THEN
        IF (v_balance<:NEW.AMOUNT) THEN
        RAISE_APPLICATION_ERROR(-20002,'You have only '||v_balance);

        ELSE
        Update Accounts
        SET Balance=Balance-:NEW.Amount
        Where :NEW.AccountId=AccountID;


        END IF;
    END IF;
END;
/

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (10, 1, SYSDATE, 100000, 'Withdrawl');

