package btech.PRACTICE.StackNQueue;

public class CustomQueue {
    protected int[]  data = new int[10];
    protected int end = 0;
    boolean isFull(){
        return end == data.length -1;
    }
    boolean isEmpty(){
        return end == -1;
    }

    void insert(int item ){
        if ( isFull()) {
            System.out.println(" Empty Queue ");
            return;
        }
        data[end++]=item;
    }
    void remove () {
        if (isEmpty()) System.out.println(" Empty queue ");
        int removed = data[0];
        for (int i=1;i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        System.out.println(removed);
    }
    void display (){
        if ( isEmpty()) System.out.println(" Empty queue ");
        for (int i=0;i<end; i++){
            System.out.print(data[i] + " -->> ");
        }
        System.out.print(" END ");
        System.out.println();
    }
//    void pussy(){
//        System.out.println(" fuck me my master plzzzz");
//        System.out.println(" Bless me with ur dick aahh!!");
//        System.out.println(" hehehhehe ");
//    }
    void front (){
        if ( isEmpty()) {
            System.out.println(" Empty queue ");
            return;
        }
         System.out.println(data[0]);
    }
    public static void main(String[] args) throws Exception {
        CustomQueue cs = new CustomQueue();
        cs.insert(23);
        cs.insert(273);
        cs.insert(243);
        cs.insert(54);
        cs.display();
        cs.front();
        cs.remove();
//        cs.pussy();
    }
}
