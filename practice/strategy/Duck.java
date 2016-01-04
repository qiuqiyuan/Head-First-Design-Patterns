interface FlyBehavior {
    public void fly();
}

interface QuackBehavior {
    public void quack();
}

class NoFly implements FlyBehavior {
    public void fly() {
        //do nothing
    };
}

class Quack implements QuackBehavior {
    public void quack() {
        //quack quack quack
    }
}

class ToyDuck extends Duck {
    ToyDuck () {
        flyBehavior = new NoFly();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I am a toyduck");
    }
}

class RocketDuck extends Duck {
    RocketDuck() {
    }

    public void display() {}
}

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks swim!");
    }
}


