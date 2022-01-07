package Jasper.First.Package3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-05
 * Time: 20:22
 * Description:
 */

class Animal {
    protected String name;
    public Animal (String name) {
        this.name = name;
    }
}

interface IFlying {
    void fly();
}
//not all animals can fly, so fly can not be implemented inside animal

interface Running {
    void run();
}

interface ISwimming {
    void swim();
}

class Bird extends Animal implements IFlying {
    public Bird (String name) {
        super(name);
    }

    @Override
    public void fly () {
        System.out.println(this.name + " is flying");
    }
}

class Forg extends Animal implements Running, ISwimming {
    public Forg (String name) {
        super(name);
    }

    @Override
    public void run () {
        System.out.println(this.name + " is running");
    }

    @Override
    public void swim () {
        System.out.println(this.name + " is swimming");
    }
}



public class Test {
    public static void runFunc (Running running) {
        running.run();
    }

    public static void swimFunc (ISwimming iSwimming) {
        iSwimming.swim();
    }

    public static void main(String[] args) {
        runFunc(new Forg("jasper"));
        runFunc(new Forg("2"));
        swimFunc(new Forg("Jasper"));
    }
}
