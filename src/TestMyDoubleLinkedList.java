/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-01
 * Time: 13:44
 * Description:
 */
public class TestMyDoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
        myDoubleLinkedList.addFirst(2);
        myDoubleLinkedList.addLast(2);
        myDoubleLinkedList.addLast(2);
        myDoubleLinkedList.addLast(2);
        myDoubleLinkedList.addLast(2);
        myDoubleLinkedList.display();
        //myDoubleLinkedList.addIndex(0, 99);
        //myDoubleLinkedList.display();
        myDoubleLinkedList.addIndex(4, 99);
        myDoubleLinkedList.display();

    }

    public static void main1(String[] args) {
        MyDoubleLinkedList myDoubleLinkedList = new MyDoubleLinkedList();
        myDoubleLinkedList.addFirst(13);
        myDoubleLinkedList.addLast(14);
        myDoubleLinkedList.addLast(15);
        myDoubleLinkedList.addLast(16);
        myDoubleLinkedList.addLast(17);
        myDoubleLinkedList.display();
        System.out.println();
        System.out.println(myDoubleLinkedList.size());
        System.out.println(myDoubleLinkedList.contains(13));
        myDoubleLinkedList.remove(14);
        myDoubleLinkedList.display();
        System.out.println();
        myDoubleLinkedList.remove(13);
        myDoubleLinkedList.display();
        System.out.println();
        myDoubleLinkedList.remove(17);
        myDoubleLinkedList.display();
        System.out.println();
        myDoubleLinkedList.addIndex(0, 99);
        myDoubleLinkedList.display();
        System.out.println();
        myDoubleLinkedList.addIndex(2, 999);
        myDoubleLinkedList.display();
        System.out.println();
        myDoubleLinkedList.addIndex(3, 9999);
        myDoubleLinkedList.display();
        System.out.println();
    }


}
