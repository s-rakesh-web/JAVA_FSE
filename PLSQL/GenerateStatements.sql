DECLARE
c_accountID NUMBER;
c_name varchar2(30);
c_balance NUMBER;
a_accountType varchar2(30);
t_date DATE;
t_amount NUMBER;

CURSOR GenerateMonthlyStatements IS 
Select a.AccountID,c.Name,
c.Balance,a.AccountType,t.TransactionDate,t.Amount
From Customers c
JOIN Accounts a ON c.CustomerId=a.CustomerId
JOIN Transactions t ON a.AccountID=t.AccountID
Where Extract(Month FROM TransactionDate)=Extract(month from SYSDATE)
AND Extract(YEAR FROM TransactionDate)=Extract(YEAR FROM SYSDATE);


BEGIN
    Open GenerateMonthlyStatements;
LOOP
    FETCH GenerateMonthlyStatements into c_accountID,c_name,
    c_balance,a_accountType,t_date,t_amount;

    EXIT WHEN GenerateMonthlyStatements%notfound;

    dbms_output.PUT_LINE('All Transation happened this month');

    dbms_output.PUT_LINE('Account ID: '||c_accountID);
    dbms_output.PUT_LINE('Name: '||c_name);
    dbms_output.PUT_LINE('Account Type: '||a_accountType);
    dbms_output.PUT_LINE('Balance: '||c_balance);
    dbms_output.PUT_LINE('Transaction Date: '||t_date);
    dbms_output.PUT_LINE('Transaction Amount: '||t_amount);



END LOOP;

END;
