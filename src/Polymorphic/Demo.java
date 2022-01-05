package Polymorphic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-03
 * Time: 18:56
 * Description:
 */

class Shape {
    public void draw () {
        System.out.println("Shape is ");
    }
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

    /**
     * When we create this method, we don't know and won't care which type shape is point to
     * so the draw method could have different performance, this action is called polymorphic
     * Advantages of using polymorphic:
     * 1. lower cost
     * 2. reduce complexity, such as if else
     * 3. easy to expand
     * @param shape
     */

    public static void DrawMap (Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        DrawMap(new Flower());
        DrawMap(new Rectangle());

        Triangle triangle = new Triangle();
        DrawMap(triangle);
    }

    //here we create a method with input shape, shape is a father object, by passing a son object
    //it will become polymorphic

    public static void main1(String[] args) {
        //Rectangle rectangle = new Rectangle();
        //rectangle.draw();

        Shape shape1 = new Rectangle();
        shape1.draw();
        Shape shape2 = new Flower();
        shape2.draw();
    }
}
