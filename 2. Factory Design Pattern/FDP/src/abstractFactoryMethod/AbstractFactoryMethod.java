package abstractFactoryMethod;

interface Burger{
    void prepare();
}

interface Pizza{
    void prepare();
}

class BasicPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Pizza");
    }
}

class StandardPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Standard Pizza");
    }
}

class PremiumPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Premium Pizza");
    }
}

class BasicBreadPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Bread Pizza");
    }
}

class StandardBreadPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Standard Bread Pizza");
    }
}

class PremiumBreadPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Creating Premium Bread Pizza");
    }
}

class BasicBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Basic Burger");
    }
}

class StandardBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

class PremiumBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

class BasicBreadBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Basic Burger");
    }
}

class StandardBreadBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

class PremiumBreadBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Creating Standard Burger");
    }
}

interface Factory{
    Burger createBurger(String name);
    Pizza createPizza(String name);
}

class SinghBurger implements Factory {
    @Override
    public Burger createBurger(String name){
        if(name=="BasicBurger"){
            return new BasicBurger();
        }else if(name=="StandardBurger"){
            return new StandardBurger();
        }else if(name=="PremiumBreadBurger"){
            return new PremiumBurger();
        }
        return null;
    }

    @Override
    public Pizza createPizza(String name) {
        if(name=="BasicPizza"){
            return new BasicPizza();
        }else if(name=="StandardPizza"){
            return new StandardPizza();
        }else if(name=="PremiumPizza"){
            return new PremiumPizza();
        }
        return null;
    }
}

class KingBurger implements Factory {
    @Override
    public Burger createBurger(String name){
        if(name=="BasicBreadBurger"){
            return new BasicBreadBurger();
        }else if(name=="StandardBreadBurger"){
            return new StandardBreadBurger();
        }else if(name=="PremiumBreadBurger"){
            return new PremiumBurger();
        }
        return null;
    }

    @Override
    public Pizza createPizza(String name) {
        if(name=="BasicBreadPizza"){
            return new BasicBreadPizza();
        }else if(name=="StandardBreadPizza"){
            return new StandardBreadPizza();
        }else if(name=="PremiumBreadPizza"){
            return new PremiumBreadPizza();
        }
        return null;
    }
}

public class AbstractFactoryMethod {
    static void main() {
        Factory pf=new KingBurger();
        Pizza bp=pf.createPizza("PremiumBreadPizza");
        bp.prepare();
    }
}
