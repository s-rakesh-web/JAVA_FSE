package JAVA;

interface PaymentProcessor{
    double ProcessPayment(double amount);
}

class Gpay{
    public double MakePayment(double amount) {
        /*
        * This method name does not match with the interface method so we can't implement it so we need an
        * adapter for this usage.
        * */
        return amount;
    }
}

class Paypal implements PaymentProcessor{
    @Override
    public double ProcessPayment(double amount) {
        return amount;
    }
}

class RayzorPay{
    public double CompletePayment(double amount){
        return amount;
    }
}
/*
* Here we don't need an adaptor for the PayPal class because it is already the same as the interface method.
* But still we need adaptor for both Gpay and RayzorPay since it is incompatible.
* */

class GpayAdaptor implements PaymentProcessor{

    Gpay g=new Gpay();
    @Override
    public double ProcessPayment(double amount) {
        return g.MakePayment(amount);
    }
}

class RazorPayAdaptor implements PaymentProcessor{

    RayzorPay r=new RayzorPay();
    @Override
    public double ProcessPayment(double amount) {
       return r.CompletePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor Paypal = new Paypal();
        PaymentProcessor Gpay = new GpayAdaptor();
        PaymentProcessor RayzorPay = new RazorPayAdaptor();

        /*
        * Now using this adaptor we can call the ProcessPayment method in the interface withuot any issue.
        * */

        System.out.println(Paypal.ProcessPayment(1000.0));
        System.out.println(Gpay.ProcessPayment(1000.0));
        System.out.println(RayzorPay.ProcessPayment(1000.0));



    }

}
