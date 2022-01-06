import java.security.spec.RSAOtherPrimeInfo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-22
 * Time: 13:31
 * Description:
 */

//node
class ListNode {
    public int value;
    public ListNode next;

    public ListNode (int val) {
        this.value = val;
    }
}

public class MyLinkedList {

    public ListNode head;
    //head of the list

    public void creatList() {
        ListNode listNode = new ListNode(10);
        ListNode listNode2 = new ListNode(11);
        ListNode listNode3 = new ListNode(12);
        ListNode listNode4 = new ListNode(13);
        ListNode listNode5 = new ListNode(14);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        this.head = listNode;
    }



    public void display () {
        ListNode current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public void display2 (ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }


    //check if contain
    public boolean contain (int key) {
        ListNode current = this.head;
        while (current != null) {
            if(current.value == key) return true;
            current = current.next;
        }
        return false;
    }

    //get size
    public int getSize () {
        int count = 0;
        ListNode current = this.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //add at head
    public void addFirst (int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = this.head;
        this.head = listNode;
    }

    //add at last
    public void addLast (int val) {

        ListNode listNode = new ListNode(val);

        if(this.head == null) {
            this.head = listNode;
        }
        else{
            ListNode current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = listNode;
        }
    }

    //find the val at index
    public ListNode findIndex (int index) {
        ListNode listNode = this.head;
        while (index - 1 != 0) {
            index--;
            listNode = listNode.next;
        }
        return listNode;
    }

    //add at specific index
    public void addAtIndex (int index, int val) {

        if(index > getSize() || index < 0) {
            System.out.println("illegal index");
            return;
        }

        if(index == 0) {
            addFirst(val);
            return;
        }

        if(index == getSize()) {
            addLast(val);
            return;
        }

        ListNode listNode = findIndex(index);
        ListNode newnode = new ListNode(val);
        newnode.next = listNode.next;
        listNode.next = newnode;
    }

    /**
     * find the previous node of key
     * @param key
     * @return
     */

    public ListNode searchPerv(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if(cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //remove
    public void remove (int val) {
        if(this.head == null) {
            System.out.println("list is empty");
            return;
        }

        if(this.head.value == val){
            this.head = this.head.next;
            return;
        }

        /*ListNode listNode = this.head;
        while (listNode.next != null && listNode.next.value != val) {
            listNode = listNode.next;
        }

        ListNode temp = listNode.next;
        listNode.next = temp.next;
        return;*/


        ListNode listNode = searchPerv(val);
        if(listNode == null) {
            System.out.println("val does not exist!");
            return;
        }

        ListNode temp = listNode.next;
        listNode.next = temp.next;

    }

    public ListNode removeAllKey (int key) {

        if(this.head == null) {
            return null;
        }

        ListNode prev = this.head;
        ListNode cur = this.head.next;

        while (cur != null) {
            if(cur.value == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }

        if(this.head.value == key) {
            this.head = this.head.next;
        }

        return this.head;
    }


    public ListNode reverseList () {

        if(this.head == null) {
            return null;
        }

        ListNode cur = this.head;
        ListNode prev = null;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        return prev;
    }

    public ListNode middleNode () {
        if(this.head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode findKthToTail (ListNode head, int k) {
        if(this.head == null || k <= 0) {
            return null;
        }

        ListNode fast = this.head;
        ListNode slow = this.head;

        /*
        while (k > 0) {
            fast = fast.next;
            k--;
        }*/

        while (fast != null){
            if(k - 1 != 0) {
                fast = fast.next;
                if(fast == null) {
                    return null;
                }
                k--;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void createLoop () {
        ListNode cur = this.head;
        while (cur != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }
        if(left == right) {
            return head;
        }

        if(head.value == left && head.next.value == right) {
            head.next.next = head;
            head = head.next;
            head.next = null;
            return head;
        }


        ListNode prev = null, leftnode = head;
        while (leftnode.value != left) {
            prev = leftnode;
            leftnode = leftnode.next;
        }
        ListNode temp = prev;

        ListNode rightnode = head;
        while (rightnode.value != right) {
            rightnode = rightnode.next;
        }
        if(rightnode.next != null) rightnode = rightnode.next;
        //find right target next node

        while (leftnode != rightnode) {
            ListNode curNext = leftnode.next;
            leftnode.next = prev;
            prev = leftnode;
            leftnode = curNext;
        }

        temp.next.next = rightnode;
        temp.next = prev;
        return head;
    }



    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }

        ListNode leftnode = head;
        if(head.value == left){
            leftnode = head;
        }
        else{
            while (leftnode.next.value != left) {
                leftnode = leftnode.next;
            }
        }

        ListNode rightnode = head;
        while (rightnode.value != right) {
            rightnode = rightnode.next;
        }
        rightnode = rightnode.next;

        //move cur to left
        ListNode cur = head;
        while (cur.value != left) {
            cur = cur.next;
        }

        ListNode prev = cur;
        while (cur != rightnode) {
            ListNode temp = cur.next;
            //potential error
            if(cur.value == left) {
                cur.next = rightnode;
            }
            else {
                cur.next = prev;
            }
            prev = cur;
            cur = temp;
        }
        leftnode.next = prev;
        return head;
    }


    public ListNode reverseBetween3(ListNode head, int left, int right) {
        //node: left and right are index
        return null;
    }

}
