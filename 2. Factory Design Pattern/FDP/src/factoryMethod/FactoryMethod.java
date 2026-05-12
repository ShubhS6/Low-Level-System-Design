package factoryMethod;

interface Burger{
    void prepare();
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

interface BurgerFactory{
    Burger createBurger(String name);
}

class SinghBurger implements BurgerFactory{
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
}

class KingBurger implements BurgerFactory{
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
}


public class FactoryMethod {
    static void main() {
        BurgerFactory bf=new KingBurger();
        Burger bbb=bf.createBurger("StandardBreadBurger");
        bbb.prepare();
    }
}
