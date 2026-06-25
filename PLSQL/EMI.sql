CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    LoanAmount IN NUMBER,
    InterestPerYear In Number,
    No_Of_Year in NUMBER
)
return NUMBER
IS
v_monthInterest NUMBER;
v_month NUMBER;
v_EMI NUMBER;

BEGIN
    
    --Convert interestPerYear to month
    v_monthInterest:=(InterestPerYear/100)/12;
    

    --Conver no of year to month
    v_month:=No_Of_Year*12;

    --EMI formula
    -- A,I,M (AMOUNT,INTEREST,MONTH)
    --A*I*(1+I)^M/((1+I)^M)-1

    v_EMI:=LoanAmount*v_monthInterest*(Power((1+v_monthInterest),v_month))/(power((1+v_monthInterest),v_month)-1);


    return TRUNC(v_EMI);
END;
/
DECLARE
v_emi NUMBER;

BEGIN
    v_emi:=CalculateMonthlyInstallment(1000000,7.2,10);
    dbms_output.put_line(v_emi);
END;

