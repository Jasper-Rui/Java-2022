package UnderstandAbstract;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-03
 * Time: 21:12
 * Description:
 */

abstract class User {
    private String name;

    public User (String name) {
        this.name = name;
    }

    public abstract void func();

    public String getName () {return this.name;}
}

class Admin extends User {

    public Admin(String name) {
        super(name);
    }

    @Override
    public void func() {

    }
}

public class Demo2 {
    public static void main(String[] args) {
        User user = new Admin("Jasper");
        System.out.println(user.getName());
    }
}
