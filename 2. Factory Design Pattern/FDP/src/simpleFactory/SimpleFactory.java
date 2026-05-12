package simpleFactory;
interface Burger{
    void prepare();
}

class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Creating Basic Burger");
    }
}

class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

class BurgerFactory{
    public Burger createBurger(String name){
        if(name=="BasicBurger"){
            return new BasicBurger();
        }else if(name=="StandardBurger"){
            return new StandardBurger();
        }else{
            return new PremiumBurger();
        }
    }
}
public class SimpleFactory {
    static void main() {
        BurgerFactory bf =new BurgerFactory();
        Burger bb=bf.createBurger("BasicBurger");
        bb.prepare();
    }
}
