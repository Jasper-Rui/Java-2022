/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-07
 * Time: 15:27
 * Description:
 */

class Money implements Cloneable{
    public double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    public String name;
    public Money money = new Money();

    public void eat () {
        System.out.println("eat!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person temp = (Person) super.clone();
        temp.money = (Money) this.money.clone();
        return temp;
        //return super.clone();
    }
}


public class CloneableInterface {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person.money.money);
        System.out.println(person1.money.money);
        System.out.println("=========================");

        person.money.money = 19.99;
        System.out.println(person.money.money);
        System.out.println(person1.money.money);
        System.out.println("=========================");
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person);
        System.out.println(person1);

        person.name = "Jasper";
        System.out.println(person);
        System.out.println(person1);

        person1.name = "Jasper2";
        System.out.println(person);
        System.out.println(person1);

    }
}
