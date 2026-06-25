CREATE TABLE AUDITLOG(
    AuditID NUMBER PRIMARY key,
    TransactionID NUMBER,
    AccountID NUMBER,
    Amount NUMBER,
    TransactionDate Date,
    TransactionType varchar2(10),
    LoggedAt Date
);

CREATE SEQUENCE audit_seq
Start with 1
INCREMENT by 1;

CREATE OR REPLACE TRIGGER LogTransaction
After INSERT on Transactions
For each row
BEGIN
    Insert into AUDITLOG(AuditID,TransactionID,AccountId,Amount,TransactionDate,TransactionType,LoggedAt)
    Values(
        audit_seq.NEXTVAL,
        :New.TransactionID,
        :New.AccountID,
        :New.Amount,
        :New.TransactionDate,
        :New.TransactionType,
        SYSDATE
    );
    DBMS_OUTPUT.PUT_LINE('Audit Log Created for TransactionID: ' || :NEW.TransactionID);
END;
/
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (3, 1, SYSDATE, 1000, 'Deposit');
