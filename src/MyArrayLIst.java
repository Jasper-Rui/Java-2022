import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-21
 * Time: 19:43
 * Description:
 */
public class MyArrayLIst {
    public int[] elem;
    public int usedSize;

    public MyArrayLIst() {
        this.elem = new int[10];
    }

    //display the list
    public void display() {
        for (int i = 0; i < this.usedSize; i++){
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //get the used size
    public int getUsedSize () {
        return this.usedSize;
    }

    //add a new element
    public void add (int pos, int data) {
        //check if the pos is a valid position
        if(pos > this.usedSize || pos < 0) {
            System.out.println("Pos is illegal");
        }
        //expand if the list is full
        if(isFUll()){
            this.elem = Arrays.copyOf(this.elem, elem.length * 2);
        }

        //add new data
        for(int i = usedSize - 1; i >= pos; i--){
            this.elem[i] = this.elem[i + 1];
        }
        this.elem[pos] = data;
        this.usedSize++;
        //size increase by 1
    }

    //expand the size if the list is full
    public boolean isFUll () {
        return this.elem.length == this.usedSize;
    }

    public boolean contains (int target) {
        for(int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == target){
                return true;
            }
        }
        return false;
    }

    public int search (int target) {
        for(int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == target){
                return i;
            }
        }
        return -1;
    }

    public int getPos (int pos) {
        if(pos < 0 || pos >= this.usedSize){
            System.out.println("illegal position");
            return -1;
        }
        return this.elem[pos];
    }

    public void setPos (int pos, int data) {
        if(pos < 0 || pos >= this.usedSize){
            System.out.println("illegal position");
        }
        this.elem[pos] = data;
    }

    public void remove (int target) {
        if(this.usedSize == 0){
            System.out.println("list is empty!");
            return;
        }
        int index = search(target);
        if(index != -1) {
            for(int i = index; i < this.usedSize - 1; i++){
                this.elem[i] = this.elem[i + 1];
            }
            this.usedSize--;
            //this.elem[usedSize] = null; if the value is a reference

        }
        else{
            System.out.println("Target is not in list");
        }
    }

    public void clear () {
        this.usedSize = 0;
    }

}
