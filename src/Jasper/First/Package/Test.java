package Jasper.First.Package;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-02
 * Time: 16:30
 * Description:
 */

class Animal {
    public String name;
    public int age;
    private int count;

    public Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat () {
        System.out.println(name + " eat()");
    }
}

//Animal is father to Dog and Bird
//Dog and Bird can access their father's public method, but not private method or instance variables

class Dog extends Animal {
    public String name;

    public Dog (String name, int age) {
        super(name, age);
    }

}

class Bird extends Animal {
    public String name;
    public String wing;

    public Bird (String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly () {
        System.out.println(name + " is " + age + " " + wing);
    }


}

public class Test {


    public static void main(String[] args) {
        Animal animal = new Dog("Jasper", 20);
        //this is called upcasting


    }
}
