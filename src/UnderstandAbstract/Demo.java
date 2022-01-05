package UnderstandAbstract;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-03
 * Time: 19:38
 * Description:
 */

/*What is abstract class?
1. a class that contains abstract method is called abstract class.
2. What is an abstract method? -> a method that has just the method definition but does not contain implementation
3. an abstract can not be instantiated
4. since abstract can only be extended
5. abstract method can have normal method
6. if a normal class extend an abstract class, it has to overwrite all abstract method
7. the point of using abstract class is to extend it
8. if an abstract class b extends a, b do not need to overwrite a's abstract method
9. combine with 8, if a normal class c extend b, c has to overwrite both abstract methods from a and b
10.
*/



abstract class Shape {
    public int a;
    public void func() {
        System.out.println("this is a normal method");
    }

    public abstract void draw(); // abstract method
}

class Rectangle extends Shape {

    @Override
    public void draw () {
        System.out.println("Rectangle 🔹");
    }
}

class Flower extends Shape {

    @Override
    public void draw () {
        System.out.println("Flower");
    }
}

class Triangle extends Shape {

    @Override
    public void draw () {
        System.out.println("Triangle");
    }
}


public class Demo {

    public static void draw (Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        //we cannot
        //Shape shape = new Shape();
        //but we can
        Shape shape = new Flower();
        draw(shape);
    }
}
