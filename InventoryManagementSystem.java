import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product{
    int productId;
    String productName;
    int quantity;
    double price;

    List<Product> prod=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public Product(){}
    public Product(int productId,String productName,int quantity,double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public void updateById(int id){

        for(Product p:prod) {
            if(p.productId==id) {

                System.out.println("What to update?");
                System.out.println("1.Name\n" +
                        "2.quantity\n" +
                        "3.price");
                int n = sc.nextInt();
                if (n == 1) {
                    p.productName = sc.next();
                } else if (n == 2) {
                    p.quantity = sc.nextInt();
                } else if (n == 3) {
                    p.price = sc.nextDouble();
                } else {
                    System.out.println("Doesn't exist");
                }
            }else{
                continue;
            }
        }


    };
    public void addProduct(int productId,String productName,int quantity,double price){

        prod.add(new Product(productId,productName,quantity,price));
    };

    public void deleteProductById(int id){
        for(Product p:prod){
            if(p.productId==id)
                prod.remove(p);
            else continue;
        }
    }


    public String toString(){
        return "ID:" +
                this.productId+
                "\nProductName:"
                +this.productName
                +"\nQuantity:" +
                this.quantity+
                "\nPrice:"+this.price;
    }
    public void display() {
        for (Product p : prod) {
            System.out.println(p);
        }
    }

}

public class InventoryManagementSystem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Product p=new Product();
        p.addProduct(1,"Biscuit",20,10.0);
        p.addProduct(2,"juice",20,10.0);

        p.updateById(2);
        p.deleteProductById(1);
        p.display();


    }

}
