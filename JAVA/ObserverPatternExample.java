package JAVA;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void Update(String name, double prize);
}



interface Stock{
    void register(Observer observer);
    void deregister(Observer observer);
    void NotifyObservers();
}

class StockMarker implements Stock{

    List<Observer> ob=new ArrayList<>();

    private String stockName;
    private double prize;
    public void setprice(String stockName,double prize){
        this.stockName=stockName;
        this.prize=prize;
        NotifyObservers();
    }


    @Override
    public void register(Observer observer) {
        ob.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        ob.remove(observer);
    }

    @Override
    public void NotifyObservers() {
        for(Observer observer:ob){
            observer.Update(stockName,prize);
        }
    }
}

class WebApp implements Observer{
    private String siteName;
    public WebApp(String siteName){
        this.siteName=siteName;
    }
    @Override
    public void Update(String name, double prize) {
        System.out.println("Web App:"+siteName+"\nStock Name:"+siteName+"\nStock Prize:"+prize);
    }
}

class MobileApp implements Observer{
    private String appName;
    public MobileApp(String appName){
        this.appName=appName;
    }

    @Override
    public void Update(String name, double prize) {
        System.out.println("Mobile App:"+appName+"\nStock Name:"+name+"\nStock Prize:"+prize);
    }
}





public class ObserverPatternExample {
    public static void main(String[] args){
        StockMarker stock=new StockMarker();
        Observer web=new WebApp("Mystock.com");
        Observer Mobile=new MobileApp("Myapp");

        stock.register(web);
        stock.register(Mobile);

        stock.deregister(Mobile);

        stock.setprice("Apple",1445.0);
        //stock.setprice("Google",383739.0);



    }

}
