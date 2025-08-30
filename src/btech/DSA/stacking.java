package btech.DSA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class stacking {
    static boolean BParanthesis(String string){
        Stack<Character> stacks = new Stack<>();
        for(char ch : string.toCharArray()){
            switch (ch){
                case '(':
                case '{':
                case '[':
                    stacks.push(ch);
                    break;
                case  ')':
                    if (stacks.isEmpty()||stacks.pop()!='(')return false;
                    break;
                case '}':
                    if (stacks.isEmpty()||stacks.pop()!='{')return false;
                    break;
                case ']':
                    if (stacks.isEmpty()||stacks.pop()!='[')return false;
                    break;
            }
        }
        return stacks.isEmpty();
    }

    static void ReverseString(String string){
        Stack<Character> stacks  = new Stack<>();
        for ( char ch : string.toCharArray()){
            stacks.push(ch);
        }
        StringBuilder str= new StringBuilder();
        while(!stacks.isEmpty()){
            str.append(stacks.pop());
        }
        System.out.println(str);
    }

    static void sort(Stack<Integer> stacks,Stack<Integer>helper){
        if (stacks.isEmpty())return;
        int top = stacks.pop();  // Every Element popping till stack empty
        sort(stacks,helper);
        cyclesort(top,helper);
    }

    private static void cyclesort(int value, Stack<Integer> helper) {
        if (helper.isEmpty()|| value>=helper.peek()){
            helper.push(value);
        }
        else {
            int top = helper.pop();
            cyclesort(value,helper);
            helper.push(top);
        }
    }

    static void PostfixExpChange(String string) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : string.toCharArray()) {
            if (!isOperator(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = doCal(ch, a, b);
                stack.push(result);
            }
        }
        System.out.println(stack.pop());
    }

    private static int doCal(char ch, int a, int b) {
        return switch (ch) {
            case '*' -> a * b;
            case '/' -> a / b;
            case '+' -> a + b;
            case '-' -> a - b;
            case '%' -> a % b;
            case '^' -> a ^ b;
            case '&' -> a & b;
            default -> throw new IllegalArgumentException("Invalid operator: " + ch);
        };
    }

    private static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '%' || ch == '^' || ch == '&';
    }

    //from : 3 + 5 * (2 - 8)      3 + 5 * 8
    // to  : 3 5 2 8 - * +        3 5 8 * +

    static void infixTopostfix(String string){
        Stack<Character> stacks = new Stack<>();
        Stack<Character> OperatorStack = new Stack<>();
        for(char ch : string.toCharArray()){
            if (isOperator(ch))OperatorStack.push(ch);
            else stacks.push(ch);
        }
        while(!OperatorStack.isEmpty()){
            char top = OperatorStack.pop();
//            System.out.println(top);
            stacks.push(top);
        }
        System.out.println(stacks);
        Stack<String> answer = new Stack<>();
        for (char ch : stacks) {
            if (!isOperator(ch))answer.push(String.valueOf(ch));
            else{
                int a = Integer.parseInt(answer.pop());
                int b = Integer.parseInt(answer.pop());
                int result = doCal(ch,b,a);
                answer.push(String.valueOf(result));
            }
        }
        System.out.println(answer.pop());
    }
    static void DupRev(String string){
        Stack<Character> stacks = new Stack<>();
        for(char ch : string.toCharArray()){
            Reverse(stacks,ch);
        }
        StringBuilder str = new StringBuilder();
        while(!stacks.isEmpty()){
            str.append(stacks.pop());
        }

        System.out.println(str);
    }
    static void Reverse(Stack<Character> stacks, char value){
        if ( stacks.isEmpty()){
            stacks.push(value);
        }
        else {
            char top = stacks.pop();
            if (top!=value)Reverse(stacks,value);
            stacks.push(top);
        }
    }

    static String Dup2(String string){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stacks = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for(char ch : string.toCharArray()){
            if (!set.contains(ch)){
                set.add(ch);
                stacks.push(ch);
            }
        }
        while(!stacks.isEmpty()){
            sb.append(stacks.pop());
        }
        return sb.reverse().toString();
    }

    static void NextGreaterElE(int[] array){
        Stack<Integer> stacks = new Stack<>();
        int idx;
        int[] res = new int[array.length];
        for(int i = 0 ; i<array.length; i++){
            while(!stacks.isEmpty() && array[i]>array[stacks.peek()]){
                res[stacks.pop()]=array[i];
            }
            stacks.push(i);
        }
        while(!stacks.isEmpty()){
            res[stacks.pop()]=-1;
        }
        System.out.println(Arrays.toString(res));
    }

    static int[] WarmDay(int[] array){
        Stack<Integer> stacks = new Stack<>();
        int[] res = new int[array.length];
        int idx;
        for (int i = 0; i < array.length; i++) {
//            idx= i;
//            while(!stacks.isEmpty() && idx<array.length && array[idx]>array[stacks.peek()] ){
//                res[stacks.peek()]= idx;
//            }
            while(!stacks.isEmpty() && array[i] > array[stacks.peek()]) {
            idx = stacks.pop();
            res[idx] = i - idx; // Store the difference in days
        }
            stacks.push(i);
        }
        return res;
    }

    static int Histogram(int[] heights){
        int MaxArea=0;
        Stack<Integer>  stacks = new Stack<>();
        int i =0 ;
        while (i<heights.length){

            if (stacks.isEmpty() || heights[i]>=heights[stacks.peek()]){
                stacks.push(i++);
            }
            else {
                int length = heights[stacks.pop()];
                int breadth = stacks.isEmpty()? i : i-stacks.peek()-1;
                MaxArea = Math.max(MaxArea,length*breadth);
            }
        }
        while ( !stacks.isEmpty()){
            int length = heights[stacks.pop()];
            int breadth = stacks.isEmpty()? i : i-stacks.peek()-1;
            MaxArea = Math.max(MaxArea,length*breadth);
        }
        return MaxArea;
    }

    static boolean isSequence(int[] ar1, int[] ar2){
        if (ar1.length!= ar2.length)return false;
        //Push array = ar1
        //Pop array = ar2;

        Stack<Integer> stacks = new Stack<>();     //A single stack is enough for checking the sequence
        int i=0 , y = 0;
        while(i< ar1.length && y<ar2.length){
                stacks.push(ar1[i++]);
                while(!stacks.isEmpty() && ar2[y]==stacks.peek()){
                    stacks.pop();
                    y++;
                }
            }
            return stacks.isEmpty() && !(i<y);    // isEmpty with check for remaining elements in stacks, i<y check for duplicacy and inccorect nums in the Pop array
    }

    static int ValidPara_Size(String string) {
        int MaxValid = 0;
        Stack<Integer> stacks = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '(') stacks.push(i);
            else {
                if (!stacks.isEmpty()) stacks.pop();
                if (stacks.isEmpty())stacks.push(i);
                MaxValid=Math.max(MaxValid,i-stacks.peek());
            }
        }
        return MaxValid;
    }

    static int[] SW_Max(int[] array , int k){
        if (array.length==0) return new int[]{0};
        if (array.length==1||k==1) return array;

        int[] res = new int[array.length-k+1];
        for (int i = 0; i <= array.length - k ; i++) {
            res[i]=getMax(array,i,i+k-1);
        }
        return res;
    }

    private static int getMax(int[] array, int start, int end) {
        int Max = array[start];  // Initialize with the first element in the window
        for (int i = start + 1; i <= end; i++) {  // Iterate through the window
            Max = Math.max(Max, array[i]);  // Find the maximum element in the window
        }
        return Max;
    }

    public static void main(String[] args) {

        System.out.println("test case 1 (Expected:{3, 3, 5, 5, 6}) : "+Arrays.toString(SW_Max(new int[]{1, 3, 1, 2, 5, 3, 6, 7}, 3)));
        System.out.println("test case 2 (Expected:{1}) : " + Arrays.toString(SW_Max(new int[]{1}, 1)));
        System.out.println("test case 3 (Expected:{3, 3, 3}) : " + Arrays.toString(SW_Max(new int[]{1, -1, 3}, 2)));
        System.out.println("test case 4 (Expected:{3,4,5}) : " + Arrays.toString(SW_Max(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println("test case 5 (Expected:{2}) : " + Arrays.toString(SW_Max(new int[]{2, 2, 2}, 3)));
        System.out.println("test case 6 (Expected:{5, 6, 6, 7}) : " + Arrays.toString(SW_Max(new int[]{1, 5, 3, 6, 7}, 2)));

//        System.out.println("Test case 1 (Expected: 2): " + ValidPara_Size("(()"));
//        System.out.println("Test case 2 (Expected: 4): " + ValidPara_Size(")()())"));
//        System.out.println("Test case 3 (Expected: 0): " + ValidPara_Size(""));
//        System.out.println("Test case 4 (Expected: 2): " + ValidPara_Size("()(()"));
//        System.out.println("Test case 5 (Expected: 4): " + ValidPara_Size("()()"));
//        System.out.println("Test case 6 (Expected: 6): " + ValidPara_Size("(()())"));
//        System.out.println("Test case 7 (Expected: 4): " + ValidPara_Size("())()()"));
//        System.out.println("Test case 8 (Expected: 0): " + ValidPara_Size(")("));
//        System.out.println("Test case 9 (Expected: 6): " + ValidPara_Size("((()))"));
//        System.out.println("Test case 10 (Expected: 4): " + ValidPara_Size(")()(())))"));
//        System.out.println("Test case 11 (Expected: 2): " + ValidPara_Size("()(()"));

//        System.out.println("Test case 1(expected: true): "+isSequence(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1})); // Test Case 1
//        System.out.println("Test case 2(expected: false): "+isSequence(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2})); // Test Case 2
//        System.out.println("Test case 3(expected: true): "+isSequence(new int[]{1, 0, 2}, new int[]{1, 2, 0}));             // Test Case 3
//        System.out.println("Test case 4(expected: true): "+isSequence(new int[]{1, 0, 2}, new int[]{1, 0, 2}));             // Test Case 4
//        System.out.println("Test case 5(expected: true): "+isSequence(new int[]{1, 2, 3}, new int[]{3, 2, 1}));             // Test Case 5
//        System.out.println("Test case 6(expected: true): "+isSequence(new int[]{1, 2, 3}, new int[]{2, 1, 3}));             // Test Case 6
//        System.out.println("Test case 7(expected: true): "+isSequence(new int[]{}, new int[]{}));                           // Test Case 7
//        System.out.println("Test case 8(expected: false): "+isSequence(new int[]{1}, new int[]{2}));                        // Test Case 8
//        infixTopostfix("3+5*2-8");
//        int[] array = {30,40,35,50,20,60,25};
//        System.out.println(Arrays.toString(WarmDay(array)));
//        DupRev("nigga");
//        System.out.println(Dup2("nigga"));
//        int[] nums = {4,5,2,10,8};
//        NextGreaterElE(nums);
//        int[] ar = {2,1,5,6,2,3};
//        System.out.println(Histogram(ar));


//        Stack<Integer> stacks = new Stack<>();
//        stacks.push(45);
//        stacks.push(4);
//        stacks.push(5);
//        stacks.push(50);
//        Stack<Integer>helper= new Stack<>();
//        sort(stacks,helper);
//        while(!helper.isEmpty()){
//            stacks.push(helper.pop());
//        }
//        for(int ele : stacks){
//            System.out.println(ele);
//        }
//
//
//
//        System.out.println();
//        System.out.println(BParanthesis("({[()}])"));
//        ReverseString("Worldo");
//        PostfixExpChange("25+5*");

//

//        MinStack mini = new MinStack();
//        mini.push(24);
//        mini.push(8);
//        mini.push(48);
//        mini.push(25);
//        System.out.println("Before Min: "+mini.MinElement());
//        mini.pop();
//        System.out.println("After Min: "+mini.MinElement());

//        StackusingArray mystack = new StackusingArray();
//        mystack.peek();
//        mystack.push(23);
//        mystack.push(8);
//        mystack.push(45);
//        mystack.push(34);
//
//        System.out.println(Arrays.toString(new StackusingArray[]{mystack}));
//        System.out.println("Peek 1: ");
//        mystack.peek();
//        System.out.println("Pooped : "+mystack.pop());
//        System.out.println("Peek 2: ");
//        mystack.peek();
    }
}

class StackusingArray{

    private static final int DefaultSize  = 5;
    private static int Top=0;
    private static int[] stacks ;

    StackusingArray(){
        stacks=new int[DefaultSize];
    }

    static boolean isEmpty(){
        return Top==DefaultSize;
    }

    static void push(int value){
        if (isEmpty()) stacks[Top++]=value;
        else System.out.println("Stack is Full.");
    }
    static int pop(){
        if (Top<0) {
            System.out.println("Nothing  to pop.");
            return -1;
        }
        else if (Top>DefaultSize) {
            System.out.println("Stack is Full");
            return -1;
        }
        int pop = stacks[Top];
        stacks[Top--]=0;
        return pop;
    }

    static int peek(){
        return stacks[Top];
    }

}

class MinStack{

    private final Stack<Integer> stacks ;
    private final Stack<Integer> Ministack;

    MinStack(){
        this.stacks= new Stack<>();
        this.Ministack= new Stack<>();
    }

    void push(int value){
        if (stacks.isEmpty()) {
            stacks.push(value);
            Ministack.push(value);
        }
        else {
            stacks.push(value);
            if (value<= Ministack.peek())Ministack.push(value);
        }
    }

    int pop(){
        if (stacks.isEmpty() || Ministack.isEmpty()) System.out.println("Empty stack");
        if (stacks.peek()== SeekMini()){
            stacks.pop();
            Ministack.pop();
        }
        return stacks.pop();
    }

    int SeekMini(){
        if (Ministack.isEmpty()) System.out.println("Empty stack ");
        return Ministack.peek();
    }
    int removeMini(){
        if (Ministack.isEmpty()) System.out.println("Empty stack ");
        return Ministack.pop();
    }
}

class LinkedStack{
    static class Node{
        Node next;
        int Data;

        Node(int value){
            this.next=null;
            this.Data=value;
        }
    }
    Node head;
    Node tail;    // Top too of the Stack

    boolean isEpmty(){
        return head==null ;
    }

    void push(int value){
        if (isEpmty()) {
            head = new Node(value);
            tail= head;
        }
        else {
            Node newNode = new Node(value);
            tail.next=newNode;
            tail=newNode;
        }
    }

    int peek(){
        return tail.Data;
    }

//    int pop(){
//
//    }
}