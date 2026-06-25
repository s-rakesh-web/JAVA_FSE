CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers for each row
BEGIN
    
    :NEW.LastModified:=SYSDATE;
END;
/
Update CUSTOMERS
Set Name='Rakesh'
Where CustomerId=1;
