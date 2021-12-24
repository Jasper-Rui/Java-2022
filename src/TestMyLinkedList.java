/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-22
 * Time: 20:25
 * Description:
 */
public class TestMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.creatList();
        myLinkedList.addFirst(99);
        myLinkedList.addLast(999);
        myLinkedList.addAtIndex(2, 111);
        myLinkedList.addAtIndex(8, 88);
        myLinkedList.addAtIndex(0, 1111);
        myLinkedList.addAtIndex(11, 111);
        myLinkedList.display();
        System.out.println();
        System.out.println(myLinkedList.contain(14));
        System.out.println(myLinkedList.getSize());

        myLinkedList.remove(11111);
        myLinkedList.remove(88);
        myLinkedList.display();

        System.out.println();

        myLinkedList.remove(1111);
        myLinkedList.display();



    }
}
