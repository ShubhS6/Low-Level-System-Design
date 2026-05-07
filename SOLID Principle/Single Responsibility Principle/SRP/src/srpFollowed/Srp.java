package srpFollowed;

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

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

class ShoppingCartInvoice{
    private ShoppingCart shoppingCart;

    public ShoppingCartInvoice(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void printInvoice(){
        for(Product p: shoppingCart.getProducts()){
            System.out.println(p.name+" "+p.price);
        }
        System.out.println(shoppingCart.calculateTotal());
    }
}


class SaveToDB{
    private ShoppingCart cart;

    public SaveToDB(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class Srp {
    public static void main() {
        ShoppingCart sc=new ShoppingCart();
        sc.addProduct(new Product("Laptop", 50000));
        sc.addProduct(new Product("Mouse", 2000));
        ShoppingCartInvoice sci=new ShoppingCartInvoice(sc);
        sci.printInvoice();
        SaveToDB stdb=new SaveToDB(sc);
        stdb.saveToDatabase();
    }
}
