abstract class Beverage {
    protected String description = "Unknown beverage";
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}


class HouseBlend extends Beverage {
    HouseBlend () {
        this.description = "HouseBlend";
    }
    @Override
        public double cost() {
            return 0.89;
        }
}

class DarkRoast extends Beverage {
    DarkRoast () {
        this.description = "DarkRoast";
    }
    @Override
        public double cost() {
            return 0.99;
        }
}

class Decaf extends Beverage {
    Decaf () {
        this.description = "Decaf";
    }
    @Override
        public double cost() {
            return 1.05;
        }
}

class Espresso extends Beverage {
    Espresso () {
        this.description = "Espresso";
    }
    @Override
        public double cost() {
            return 1.99;
        }
}

abstract class CondimentsDecorator extends Beverage {
    protected Beverage beverage; // For decotrator pattern
    public abstract String getDescription();
}

class Whip extends CondimentsDecorator {

    public Whip (Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription () {
        return this.beverage.getDescription() + " Whip";
    }

    public double cost() {
        return 0.10 + beverage.cost();
    }
}

class Mocha extends CondimentsDecorator {
    public Mocha (Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription () {
        return this.beverage.getDescription() + " Mocha";
    }

    public double cost() {
        return 0.20 + beverage.cost();
    }
}

class StreamedMilk extends CondimentsDecorator {
    public StreamedMilk (Beverage beverage) {
        this.beverage = beverage; 
    }

    public String getDescription () {
        return this.beverage.getDescription() + " SteamMilk";
    }

    public double cost() {
        return 0.10 + beverage.cost();
    }
}

public class StarBuzz {
    public static void main(String[] args){
        Beverage drink1 = new Mocha(new Mocha(new DarkRoast()));
        System.out.println( drink1.getDescription() + " costs: " + drink1.cost());
    }
}
