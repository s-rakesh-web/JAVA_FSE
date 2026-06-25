DECLARE
v_id NUMBER;
v_amount NUMBER;
v_interestRate NUMBER;
v_newinterest NUMBER;


Cursor UpdateLoanInterestRate Is 
select LoanID,LoanAmount From Loans
order by LoanID; -- Without order by it is fetching in a decending order

BEGIN
    OPEN UpdateLoanInterestRate;
LOOP
    FETCH UpdateLoanInterestRate into v_id,v_amount;
    exit when UpdateLoanInterestRate%notfound;
    --new Policy

    IF v_amount>10000 then
    v_interestRate:=8;
    ELSIF v_amount>5000 then
    v_interestRate:=6;
    ELSIF v_amount<=5000 then
    v_interestRate:=5;
    END IF;

    UPDATE Loans
    SET InterestRate=v_interestRate
    WHERE LoanId=v_id;

    SELECT InterestRate into v_newinterest From Loans where LoanId=v_id;

    dbms_output.put_line('changed interest');
    dbms_output.put_line('Loan ID: '||v_id||chr(10)
    ||'New interest: '||v_newinterest||chr(10)
    ||'Loan Amount: '||v_amount);


END LOOP;
close UpdateLoanInterestRate;

END;
