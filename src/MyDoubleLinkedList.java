/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-30
 * Time: 22:38
 * Description:
 */


class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node (int val) {
        this.val = val;
    }
}
public class MyDoubleLinkedList {
    public Node head;
    public Node last;
    //add first
    public void addFirst(int data){
        Node node = new Node(data);
        if(size() == 0) {
            this.head = node;
            this.last = node;
        }
        else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //add last
    public void addLast(int data){
        Node node = new Node(data);
        if(size() == 0) {
            this.head = node;
            this.last = node;
        }
        else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    public Node searchIndex (int index) {
        if(index < 0 || index > size()){
            return null;
        }

        Node node = this.head;
        while (index != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    //insert at index
    public boolean addIndex(int index,int data){
        if(index > size() || index < 0) {
            System.out.println("index is illegal");
            return false;
        }

        Node node = searchIndex(index);
        Node newNode = new Node(data);

        /*if(node == this.head) {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        else if(node == this.last) {
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        else{
            node.prev.next = newNode;
            node.prev = newNode;
            newNode.next = node;
            newNode.prev = node.prev;
        }*/


        //another way
        if (index == 0) {
            addFirst(data);
            return true;
        }

        if (index == size()) {
            addLast(data);
            return true;
        }

        node.prev.next = newNode;
        node.prev = newNode;
        newNode.next = node;
        newNode.prev = node.prev;
        return true;
    }

    //check key
    public boolean contains(int key){
        Node node = this.head;

        while (node != null) {
            if(node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //delete key
    public void remove(int key){
        Node node = this.head;

        while (node != null) {
            if(node.val == key) {
                //there are 3 different situation
                //1 head
                //2 tail
                //3 middle
                if(node == head) {
                    head = head.next;
                    //what if head.next is null?
                    if(head != null) head.prev = null;
                    //means head has next valid node

                    else last = null;
                    //means there exist only one node, since head and last point to same node
                    //when head point to null, so do last
                }
                else if(node == last) {
                    last = last.prev;
                    last.next = null;
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                return;
            }
            node = node.next;
        }
    }

    //remove all keys
    public void removeAllKey(int key){
        Node node = this.head;

        while (node != null) {
            if(node.val == key) {
                //there are 3 different situation
                //1 head
                //2 tail
                //3 middle
                if(node == head) {
                    head = head.next;
                    //what if head.next is null?
                    if(head != null) head.prev = null;
                        //means head has next valid node

                    else last = null;
                    //means there exist only one node, since head and last point to same node
                    //when head point to null, so do last
                }
                else if(node == last) {
                    last = last.prev;
                    last.next = null;
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
            node = node.next;
        }
    }

    //get size
    public int size(){
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void display(){
        Node node = this.head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void clear(){
        while (this.head != null) {
            Node nodeNext = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = nodeNext;
        }
        this.last = null;

    }

}
