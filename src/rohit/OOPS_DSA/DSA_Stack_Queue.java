package rohit.OOPS_DSA;

import java.util.ArrayList;

public class DSA_Stack_Queue {
    MyStack stack = new MyStack();
    QueueByArray queue = new QueueByArray();
}

//-----------------------------------------------
class MyStack {
    private int size;
    private int[] array;
    private final int DEFAULT_SIZE;

    MyStack() {
        DEFAULT_SIZE = 10;
        array = new int[DEFAULT_SIZE];
        size = 0;  // Initialize size to 0
    }

    private int[] getArray() {
        return this.array;
    }

    private void setArray(int[] array) {
        this.array = array;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(int value){
        if (isEmpty()){
            array[size]=value;
            size++;
        }
        if (size==DEFAULT_SIZE){
            int[] newArray = new int[array.length*2];
            System.arraycopy(array,0,newArray,0,newArray.length);
        }
    }
}
///----------------------------------------------

class StackGeneric<T> {
    private int size;
    private ArrayList<T> array;

    StackGeneric() {
        int DEFAULT_SIZE = 10;
        array = new ArrayList<>(DEFAULT_SIZE);
        size = 0;  // Initialize size to 0
    }

    private ArrayList<T> getArray() {
        return this.array;
    }

    private void setArray(ArrayList<T> array) {
        this.array = array;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(T value) {
        array.add(value);
        size++;
    }

    void display() {
        for (int i = size - 1; i >= 0; i--) {
            T value = array.get(i);
            System.out.println(" 🔻 ");
            System.out.println("| " + value + " |");
        }
    }

    synchronized void pop(){
        array.remove(size-1);
        System.out.println();
        size--;
    }

}


class QueueByArray {
    private int[] array;
    private  int size;
    private final int DEFAULT_SiZE;
    QueueByArray(){
        DEFAULT_SiZE = 10;
        array=new int[DEFAULT_SiZE];
    }

    private int[] getQueue(){
        return this.array;
    }
    private int[] setQueue(int[] array){
        return this.array=array;
    }
    boolean isnull(){
        return array[0]==0;
    }
    int getSize(){
        return this.size;
    }
    void push(int value){
        if (isnull()){
            array[0]=value;
            size++;
            return;
        }
        if (size-1==DEFAULT_SiZE){
            int[] newarray = new int[array.length*2];
            System.arraycopy(array,0,newarray,0,newarray.length);
            setQueue(newarray);
        }
        array[size]=value;
        size++;
    }
    int peek(){
        return array[size-1];
    }
    int peek(int index){
        return array[index];
    }
    int pop(){
        int element = peek(0);

        for (int i = 0; i < size; i++) {
            array[i]=array[i+1];
        }
        array[size]=0;
        size--;
        return element ;

    }
    int find(int index){
        return array[index];
    }
    int giveIndex(int value){
        int i;
        for (i = 0; i < size; i++) {
            if (array[i]==value){
                return i;
            }
        }
        return -0;
    }
    boolean check(int value , int index){
        return array[index]==value;
    }
    boolean check(int value){
        for (int i : array){
            if (i==value) return true;
        }
        return false;
    }
    int element(int value){// It will check the element if present
        int index;
        if (check(value)){
            index=giveIndex(value);
            return find(index);
        }
        return -0;
    }
}
class QueueLinkedList{

}