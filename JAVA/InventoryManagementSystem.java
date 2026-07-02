package JAVA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Product{
    int productId;
    String productName;
    int quantity;
    double price;
    //public Product(){}
    public Product(int productId,String productName,int quantity,double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
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

}

class Inventory{
    private List<Product> prod = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addProduct(Product product) {
        prod.add(product);
        System.out.println("Product added successfully.");
    }

    public void updateById(int id) {
        for (Product p : prod) {
            if (p.productId == id) {
                System.out.println("What do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. Quantity");
                System.out.println("3. Price");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter new product name: ");
                        p.productName = sc.next();
                        break;

                    case 2:
                        System.out.print("Enter new quantity: ");
                        p.quantity = sc.nextInt();
                        break;

                    case 3:
                        System.out.print("Enter new price: ");
                        p.price = sc.nextDouble();
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProductById(int id) {
        boolean removed = prod.removeIf(p -> p.productId == id);

        if (removed) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void display() {
        if (prod.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product p : prod) {
            System.out.println(p);
        }
    }
}


public class InventoryManagementSystem {
    public static void main(String[] args){
        //Scanner sc=new Scanner(System.in);
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(1, "Biscuit", 20, 10.0));
        inventory.addProduct(new Product(2, "Juice", 15, 25.0));

        inventory.display();

        inventory.updateById(2);

        inventory.deleteProductById(1);

        System.out.println("\nUpdated Inventory:");
        inventory.display();


    }

}
