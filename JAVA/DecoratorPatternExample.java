package JAVA;

interface Notifier{
    String getDescription();
    String send(String message);
}

class EmailNotifier implements Notifier{

    @Override
    public String getDescription() {
        return "Email";
    }

    @Override
    public String send(String message) {
        return "Email:"+message;
    }
}

abstract class NotifierDecorator implements Notifier{
    Notifier notify;
    public NotifierDecorator(Notifier notify){
        this.notify=notify;
    }
}
class SMSNotifierDecorator extends NotifierDecorator{

    public SMSNotifierDecorator(Notifier notify) {
        super(notify);
    }

    @Override
    public String getDescription() {
        return notify.getDescription()+"+SMS";
    }

    @Override
    public String send(String message) {
        return notify.send(message)+"\nSMS:"+message;
    }
}

class SlacNotifierDecorator extends NotifierDecorator{

    public SlacNotifierDecorator(Notifier notify) {
        super(notify);
    }

    @Override
    public String getDescription() {
        return notify.getDescription()+"+Slac";
    }

    @Override
    public String send(String message) {
        return notify.send(message)+" \nSlac: "+message;
    }
}


public class DecoratorPatternExample {
    public static void main(String[] arsg) {


        Notifier email = new EmailNotifier();
        System.out.println("-----"+email.getDescription()+"-----");
        System.out.println(email.send("Server down"));

        Notifier SMS=new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("-----"+SMS.getDescription()+"-----");
        System.out.println(SMS.send("Server down"));

        Notifier Slac=new SlacNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("-----"+Slac.getDescription()+"-----");
        System.out.println(Slac.send("server down"));

    }
}
