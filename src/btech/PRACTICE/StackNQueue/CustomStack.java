package btech.PRACTICE.StackNQueue;

class CustomStack {
    protected int[] arr;
    protected int ptr=-1;
    private static final int DEFAULT_SIZE = 5;
    CustomStack(){
        this(DEFAULT_SIZE);
    }
    CustomStack(int size ) {
        this.arr = new int[size];
    }
    boolean isFull(){
        return ptr == arr.length -1;
    }
    boolean isEmpty(){
        return ptr == -1;
    }

    boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        arr[ptr]=item;
        return true;
    }

    int pop() throws CustomException {
        if ( isEmpty())  throw new CustomException(" Stack is Empty ");

        return ptr--;
    }
    void peek() throws CustomException{
        if ( isEmpty())throw new CustomException(" Stack is Empty ");
        System.out.println(arr[ptr]);
    }
    public static void main(String[] args) throws Exception {
        CustomStack cs = new CustomStack();
        cs.push(34);
        cs.push(2);
        System.out.println(cs.pop());
    }
}