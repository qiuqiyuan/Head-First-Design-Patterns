import java.util.*;

abstract class Pizza {
    protected Sauce sauce;
    protected Dough dough;
    protected Topping[] toppings;

    public abstract void prepare();
    public void bake(){};
    public void cut(){};
    public void box(){};
}

class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public void prepare(){
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        toppings  = ingredientFactory.createToppings();
    };

    public CheesePizza(PizzaIngredientFactory factory){
        this.ingredientFactory = factory;
    }
}

class VeggiePizza extends Pizza {
    private PizzaIngredientFactory factory;
    public void prepare(){
    };

    public VeggiePizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }
}

class ClamPizza extends Pizza {
    private PizzaIngredientFactory factory;
    public void prepare(){};

    public ClamPizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }
}

class PepperoniPizza extends Pizza {
    private PizzaIngredientFactory factory;
    public void prepare(){};

    public PepperoniPizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }
}

interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Topping[] createToppings();
}


abstract class Dough {}
abstract class Sauce {}
abstract class Cheese {}
abstract class Topping {}

class CrustDough extends Dough {}
class ThinDough extends Dough {}

class CreamSauce extends Sauce {}
class TomatoSauce extends Sauce {}

class PepperJack extends Cheese {}
class American extends Cheese {}

class Bacon extends Topping {}
class PineApple extends Topping {}

class NYIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new CrustDough();
    }
    public Sauce createSauce(){
        return new CreamSauce(); 
    }
    public Cheese createCheese() {
        return new PepperJack();
    }
    public Topping[] createToppings(){
        Topping toppings[] = {new Bacon()};
        return toppings;
    }
}

class ChicagoIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ThinDough();
    }
    public Sauce createSauce(){
        return new TomatoSauce(); 
    }
    public Cheese createCheese() {
        return new American();
    }
    public Topping[] createToppings(){
        Topping toppings[] = {new Bacon(), new PineApple()};
        return toppings;
    }
}

//////PizzaStore
public abstract class PizzaStore {
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

class NYPizzaStore extends PizzaStore {
    PizzaIngredientFactory ingredientFactory;

    public NYPizzaStore(){
        ingredientFactory = new NYIngredientFactory();
    }

    public Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
        } else if (item.equals("veggie")) { 
            pizza = new VeggiePizza(ingredientFactory);
        } else if (item.equals("clam")) { 
            pizza = new ClamPizza(ingredientFactory);
        } else if (item.equals("pepperoni")) { 
            pizza = new PepperoniPizza(ingredientFactory);
        }
        return pizza;
    }

}

class ChicagoPizzaStore extends PizzaStore {
    PizzaIngredientFactory ingredientFactory;
    public ChicagoPizzaStore(){
        ingredientFactory = new ChicagoIngredientFactory();
    }
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new CheesePizza(ingredientFactory);
        } else if (item.equals("veggie")) { 
            return new VeggiePizza(ingredientFactory);
        } else if (item.equals("clam")) { 
            return new ClamPizza(ingredientFactory);
        } else if (item.equals("pepperoni")) { 
            return new PepperoniPizza(ingredientFactory);
        } else {
            return null; 
        }
    }
}
