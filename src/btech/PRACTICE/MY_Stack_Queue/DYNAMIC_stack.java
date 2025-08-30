package btech.PRACTICE.MY_Stack_Queue;

public class DYNAMIC_stack extends MyStack {
    @Override
    void push(int item) throws MyStackException {
        if ( isFull()){
            int[] temp = new int[Arr.length*2];
            System.arraycopy(Arr,0,temp,0,Arr.length);
            Arr = temp;
        }
        super.push(item);
    }
    public static void main(String[] args) throws MyStackException {
        MyStack stack = new DYNAMIC_stack();
        stack.push(32);
        stack.push(2);
        stack.push(3);
        stack.push(8);
        stack.push(90);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
