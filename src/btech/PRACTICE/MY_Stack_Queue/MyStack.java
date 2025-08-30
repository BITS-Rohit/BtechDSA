package btech.PRACTICE.MY_Stack_Queue;

class MyStack {
    protected int[]  Arr  = new int[2];
    protected int pointer =-1;
    boolean isFull(){
        return pointer == Arr.length-1;
    }
    boolean isEmpty(){
        return pointer == -1;
    }

    void push(int item) throws MyStackException{
        if (isFull())  throw new MyStackException(" Stack is Empty ");
        pointer++;
        Arr[pointer]= item;
    }
    int pop() throws MyStackException{
        if ( isEmpty()) throw new MyStackException(" Stack is Empty ");
        return Arr[pointer--];
    }
    void peek() throws MyStackException{
        if ( isEmpty()) throw new MyStackException(" Stack is Empty ");
        System.out.println(Arr[pointer]);
    }
}
