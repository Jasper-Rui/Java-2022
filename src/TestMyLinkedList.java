/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-22
 * Time: 20:25
 * Description:
 */
public class TestMyLinkedList {

    public static ListNode mergetTwoList (ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if(list1.value < list2.value) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if(list1 != null) {
            temp.next = list1;
        }

        if(list2 != null) {
            temp.next = list2;
        }

        return head.next;
    }


    public static ListNode partition(ListNode head, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        ListNode cur = head;

        while (cur != null) {
            if(cur.value < x) {
                //first time
                if(beforeStart == null){
                    beforeStart = cur;
                    beforeEnd = cur;
                }
                //non - first time
                else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            }
            else {
                if(afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                }
                else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        //question
        //will all values will smaller than x?
        //what if every value is smaller than x?

        if(beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;

        if(afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;

        while (cur != null) {
            if(cur.next != null && cur.value == cur.next.value) {
                while (cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else {
                temp.next = cur;
                cur = cur.next;
                temp = temp.next;
            }
        }

        //avoid last node is duplicated as well, so set the last non-repeated node next to null
        temp.next = null;
        return newHead.next;
    }






    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(13);
        myLinkedList.addLast(15);
        myLinkedList.addLast(24);
        myLinkedList.addLast(133);


        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(25);
        myLinkedList2.addLast(132);

        ListNode ret = mergetTwoList(myLinkedList.head, myLinkedList2.head);
        myLinkedList.display2(ret);

    }

    public static void main1(String[] args) {
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
        myLinkedList.head = myLinkedList.reverseList();

        System.out.println();

        myLinkedList.display();


    }
}
