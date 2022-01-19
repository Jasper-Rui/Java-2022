package MyQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-16
 * Time: 11:31
 * Description:
 */

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

}


public class MyQueuee {

    public Node head;
    public Node last;


    /**
     * add to lask
     * @param val
     */
    public void offer (int val) {
        Node node = new Node(val);

        if(head == null) {
            this.head = node;
            this.last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }

    /**
     * pop out of queue
     * @return
     */
    public int poll () {
        if(isEmpty()) {
            throw new RuntimeException("queue is empty");
        }

        int old = head.value;
        this.head = head.next;
        return old;
    }

    public int peek () {
        if(isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return head.value;
    }



    public boolean isEmpty () {
        return this.head == null;
    }


}
