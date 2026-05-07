package OCPFollow;


import java.util.ArrayList;
import java.util.List;

//in this we create interface of saving the database and then impliment on each
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

interface SaveToDatabase{
    void save(ShoppingCart shoppingCart);
}


class SaveToSQl implements SaveToDatabase{

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving to sql database");
    }
}

class SaveToMongo implements SaveToDatabase{

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving to mongo");
    }
}



public class OcpFollow {
    static void main() {
        ShoppingCart sc=new ShoppingCart();
        sc.addProduct(new Product("Laptop", 50000));
        sc.addProduct(new Product("Mouse", 2000));
        ShoppingCartInvoice sci=new ShoppingCartInvoice(sc);
        sci.printInvoice();
        SaveToSQl sts=new SaveToSQl();
        sts.save(sc);
        SaveToMongo stm=new SaveToMongo();
        stm.save(sc);
    }
}
