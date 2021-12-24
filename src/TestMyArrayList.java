/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-21
 * Time: 20:52
 * Description:
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayLIst myArrayLIst = new MyArrayLIst();
        myArrayLIst.add(0, 1);
        myArrayLIst.add(1, 2);
        myArrayLIst.add(2, 3);
        myArrayLIst.add(3, 4);
        myArrayLIst.add(4, 5);
        myArrayLIst.display();
        System.out.println(myArrayLIst.contains(3));
        System.out.println(myArrayLIst.getPos(3));
        System.out.println(myArrayLIst.getPos(33));
        myArrayLIst.setPos(0, 99);
        myArrayLIst.display();
    }
}
