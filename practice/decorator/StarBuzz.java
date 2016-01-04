abstract class Beverage {
    private String description = "Unknown beverage";
    public double cost() {
        return 0.0;
    };
}


class HouseBlend extends Beverage {
    @Override
        public double cost() {
            return 0.89;
        }
}

class DarkRoast extends Beverage {
    @Override
        public double cost() {
            return 0.99;
        }
}

class Decaf extends Beverage {
    @Override
        public double cost() {
            return 1.05;
        }
}

class Espresso extends Beverage {
    @Override
        public double cost() {
            return 1.99;
        }
}


abstract class CondimentsDecorator extends Beverage {
    protected Beverage beverage;
}

class Whip extends CondimentsDecorator {
    public Whip (Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return 0.10 + beverage.cost();
    }
}

class Mocha extends CondimentsDecorator {
    public Mocha (Beverage beverage) {
        this.beverage = beverage;
    }
    public double cost() {
        return 0.20 + beverage.cost();
    }
}

class StreamedMilk extends CondimentsDecorator {
    public StreamedMilk (Beverage beverage) {
        this.beverage = beverage; 
    }
    public double cost() {
        return 0.10 + beverage.cost();
    }
}

public class StarBuzz {
    public static void main(String[] args){
        Beverage doubleMochaDarkRoast = new Mocha(new Mocha(new DarkRoast()));
        System.out.println("Double Mocha DarkRoast costs: ");
        System.out.println(doubleMochaDarkRoast.cost());
    }
}
