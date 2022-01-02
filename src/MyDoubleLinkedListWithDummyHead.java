/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-02
 * Time: 14:30
 * Description:
 */
public class MyDoubleLinkedListWithDummyHead {
        public Node dummyhead;
        public Node last;

        public MyDoubleLinkedListWithDummyHead() {
            this.dummyhead = new Node(-1);
        }

        //add first
        public void addFirst(int data){
            Node node = new Node(data);
            if(this.dummyhead.next == null) {
                this.dummyhead.next = node;
                node.prev = this.dummyhead;
                this.last = node;
            }
            else{
                node.next = this.dummyhead.next;
                node.prev = dummyhead;
                node.next.prev = node;
                this.dummyhead.next = node;
            }
        }

        //add last
        public void addLast(int data){
            Node node = new Node(data);
            if(size() == 0) {
                addFirst(data);
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

            Node node = this.dummyhead.next;
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
            Node node = this.dummyhead.next;

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
            Node node = this.dummyhead.next;

            while (node != null) {
                if(node.val == key) {
                    //there are 3 different situation
                    //1 head
                    //2 tail
                    //3 middle
                    if(node == this.dummyhead.next) {
                        this.dummyhead.next = node.next;
                        if(node.next != null) node.next.prev = this.dummyhead;
                        //means head has next valid node

                        //what if head.next is null?
                        else last = null;
                        //means it becomes an empty list, make last = null;

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
            Node node = this.dummyhead.next;

            while (node != null) {
                if(node.val == key) {
                    //there are 3 different situation
                    //1 head
                    //2 tail
                    //3 middle
                    if(node == this.dummyhead.next) {
                        this.dummyhead.next = node.next;
                        if(node.next != null) node.next.prev = this.dummyhead;
                            //means head has next valid node

                            //what if head.next is null?
                        else last = null;
                        //means it becomes an empty list, make last = null;

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
            Node node = this.dummyhead.next;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
        }

        public void display(){
            Node node = this.dummyhead.next;
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }

        public void clear(){
            while (this.dummyhead != null) {
                Node nodeNext = this.dummyhead.next;
                this.dummyhead.next = null;
                this.dummyhead.prev = null;
                this.dummyhead = nodeNext;
            }
            this.last = null;
        }

}
