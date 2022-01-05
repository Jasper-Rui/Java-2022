package UnderstandAbstract;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-04
 * Time: 12:22
 * Description:
 */

interface IA {
    int a = 10;
    void funcA(); // public abstract
}

interface IB {
    int b = 10;
    void funcB(); // public abstract
}

class A implements IA, IB {
    @Override
    public void funcA () {
        System.out.println("A");
        System.out.println(a);
    }

    @Override
    public void funcB () {
        System.out.println("B");
        System.out.println(b);
    }

}

public class Demo4 {
}
