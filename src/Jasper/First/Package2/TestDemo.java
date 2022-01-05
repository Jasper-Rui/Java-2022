package Jasper.First.Package2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-03
 * Time: 16:10
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

    public Dog (String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(name + " eattttttttttttttttttt!");
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

public class TestDemo {

    public static void main(String[] args) {
        Animal animal = new Dog("Jasper", 22);
        animal.eat();
    }


    public static void func (Animal animal) {
        //do something
    }

    public static Animal func2 (Animal animal) {
        Dog dog1 = new Dog("Jasper3", 23);
        return dog1;
    }

    public static void main1(String[] args) {
        //this is called upcasting
        //When will upcasting happen?
        //1.
        Animal animal = new Dog("Jasper", 20);

        //2. As a parameter pass to method
        func(animal);
        //or
        Dog dog = new Dog("Jasper2", 22);
        func(dog);

        //3. As a parameter return from method



    }
}

