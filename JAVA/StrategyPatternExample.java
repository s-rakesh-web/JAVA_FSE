package JAVA;

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCard implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card Processing Payment:"+amount);
    }
}

class PayPal implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Paypal Processing Payment:"+amount);
    }
}

class PaymentContext{
    PaymentStrategy paymentStrategy;
    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public void payment(double amount){
        paymentStrategy.pay(amount);
    }
}



public class StrategyPatternExample {
    public static void main(String[] args){
        PaymentContext context=new PaymentContext(new CreditCard());
        context.payment(161617.0);

        PaymentContext con=new PaymentContext(new PayPal());
        con.payment(161617.0);


    }
}
