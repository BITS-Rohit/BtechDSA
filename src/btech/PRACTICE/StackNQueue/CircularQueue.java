package btech.PRACTICE.StackNQueue;

public class CircularQueue {
    protected int[]  data;
    protected  int front  = 0;
    int size;
    static final int DEFAULT_SIZE= 10;
    protected int end = 0;
    CircularQueue(int size){
        this.data=new int[size];
    }
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    boolean isFull(){
        return size == data.length -1;
    }
    boolean isEmpty(){
        return end == -1;
    }
    void insert(int item){
        if (isFull()) {
            System.out.println(" Stack is Full ");
            return;
        }
        data[end++]=item;
        end = end%data.length;
        size++;
    }
    void remove(){
        if ( isEmpty()){
            System.out.println(" Stack is Empty");
            return;
        }
        int removed = data[front++];
        front = front% data.length;
        size--;
        System.out.println("Removed item :  "+ removed);
    }
    void Front(){
        if ( isEmpty()) {
            System.out.println(" Empty queue ");
            return;
        }
        System.out.println(data[front]);
    }
    void display (){
        if ( isEmpty()) System.out.println(" Empty queue ");
        int i= front;
        do{
            System.out.print(data[i]+ " -> ");
            i ++;
            i = i% data.length;
        }
        while (i!=end);
        System.out.print(" END ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.insert(23);
        cq.insert(554);
        cq.insert(4);
        cq.insert(54);
        cq.insert(55);
        cq.display();
        cq.remove();
        cq.Front();
        cq.insert(133);
        cq.insert(433);
        cq.display();
    }
}
