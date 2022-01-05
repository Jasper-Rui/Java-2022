package UnderstandAbstract.Demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-04
 * Time: 11:51
 * Description:
 */

/*
interface
1. most normal methods in an interface, does not have a body
2. but we can use default to create a method
3. An interface is a completely "abstract class" that is used to group related methods with empty bodies:
4. an interface can have static method
5. all methods inside an interface are public
6. abstract method default name start with "public abstract"
7. interface can not be instantiated
8. the relationship between class and interfaces are though implements
9.

*/
interface IShape {
    public abstract void draw();
    /*default public void func() {
        System.out.println("123");
    }

    public static void func2() {
        System.out.println("1234");
    }*/
}

class Rectangle implements IShape {
    @Override
    public void draw () {
        System.out.println("Rectangle 🔹");
    }
}

class Flower implements IShape {
    @Override
    public void draw () {
        System.out.println("Flower");
    }
}

class Triangle implements IShape {
    @Override
    public void draw () {
        System.out.println("Triangle");
    }
}

public class Demo3 {

    public static void DrawMap (IShape iShape) {
        iShape.draw();
    }
    //instance variables

    public static void main(String[] args) {
        IShape iShape = new Rectangle();
        iShape.draw();

    }
}
