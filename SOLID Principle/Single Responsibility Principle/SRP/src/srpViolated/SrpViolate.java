package srpViolated;

import java.util.ArrayList;
import java.util.List;

class Product{
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{
    private List<Product> products=new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getProducts(){
        return products;
    }

    public double calculateTotal(){
        double total=0;
        for(Product p: products){
            total+=p.price;
        }
        return total;
    }

    public void saveToDb(){
        System.out.println("saving data to db");
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }
}


//here the problem is that shopping cart class should be only for list of items and total it should not
//use for print invoice and save the database....
public class SrpViolate {
    public static void main() {
        ShoppingCart sc=new ShoppingCart();
        sc.addProduct(new Product("Laptop",30000));
        sc.addProduct(new Product("Keyboard",2000));
        System.out.println(sc.calculateTotal());
        sc.saveToDb();
        sc.printInvoice();
    }

}
