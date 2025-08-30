package Code;

import java.util.*;

public class stack {
    static List<int[]> memoryLeak = new ArrayList<>();
    ///////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////
    static boolean checksymbolorder(String string) {
        //Given a string containing just the characters (, ), {, }, [, and ],
        // determine if the input string is valid.
        // An input string is valid if the brackets are closed in the correct order.
        Stack<Character> stack = new Stack<>();
        for (char ch : string.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                else {
                    if (ch == ')' && stack.pop() != '(') return false;
                    if (ch == '}' && stack.pop() != '{') return false;
                    if (ch == ']' && stack.pop() != '[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

class stackLinkList {
    // stack using Singly Linked List
    // where the top of the stack is the head of the linked list
    private static class Node {

        private final int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    boolean isEmpty() {
        return top == null;
    }

    void push(int value) {
        Node newnode = new Node(value);
        newnode.next = top;
        top = newnode;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Empty Stack ");
            return;
        }
        System.out.println("Top Element : " + top.data);
    }

    int pop() {
        if (isEmpty()) return -1;
        int popitem = top.data;
        top = top.next;
        return popitem;
    }

    ///////////////////////////////////////    ChatGPT      ///////////////////////////
    // Reverse a stack using recursion
    static void reverseStack(Stack<Integer> stack, Stack<Integer> newStack) {
        if (stack.isEmpty()) {
            System.out.println(newStack);
            return;
        }
        int n = stack.pop();
        newStack.push(n);
        reverseStack(stack, newStack);
    }

    static void OptimisedRevStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        OptimisedRevStack(stack);
        insert(stack, top);
    }

    private static void insert(Stack<Integer> stack, int top) {
        if (stack.isEmpty()) stack.push(top);
        else {
            int t = stack.pop();
            insert(stack, t);
            stack.push(top);
        }
    }

    static void RPN(String[] strings) {      //Reverse Polish Notation (Postfix expression)
        Stack<Integer> stack = new Stack<>();
        for (String str : strings) {
            if (isOperand(str)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int ans = Useoperand(str, op1, op2);
                stack.push(ans);
            } else {
                int n = Integer.parseInt(str);
                stack.push(n);
            }
        }
    }

    private static boolean isOperand(String str) {
        return str.equals("*") || str.equals("-") || str.equals("+") || str.equals("/");
    }

    private static int Useoperand(String str, int op1, int op2) {
        int ans = 0;
        return switch (str) {
            case "*" -> ans + (op1 * op2);
            case "+" -> ans + (op1 + op2);
            case "-" -> ans + (op1 - op2);
            case "/" -> ans + (op1 / op2);
            default -> ans;
        };
    }

    static void nextGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        int num = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    num = arr[j];
                    n = j - i;
                    break;
                }
            }
            i += n - 1;
            if (i == arr.length) stack.push(-1);
            for (int j = 0; j < n; j++) {
                stack.push(num);
            }
        }
    }

    static void NGE(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = arr[i];
            }
            stack.push(i);
        }
        for (int i : res) System.out.println(i);
    }

    static void sortbystack(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int top = st.pop();
        sortbystack(st);
        sorting(st, top);
    }

    private static void sorting(Stack<Integer> st, int value) {
        if (st.isEmpty() || st.peek() <= value) {
            st.push(value);
        } else {
            int top = st.pop();
            sorting(st, value);
            st.push(top);
        }
    }

    public static int largestRectangleArea(int[] heights) {
        // Stack to store indices of the histogram bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {//2 1 5 6 2 3
            // If the current bar is shorter than the bar at the top of the stack
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            // Push the current bar index to the stack
            stack.push(i);
        }
        // Calculate the area for the remaining bars in the stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

//    public int minAddToMakeValid(String s) {
//        Stack<Character> stacks = new Stack<>();
//        for(char ch : s.toCharArray()){
//            if (ch == '(') stacks.push(ch);
//            else if (ch == ')' && stacks.peek()=='(' && !stacks.isEmpty())stacks.pop();
//            else stacks.push(ch);
//        }
//        return stacks.size();
//    }
    public int minAddToMakeValid(String s) {
        int nOpens = 0, minAdd = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                nOpens++;
            } else if (c == ')') {
                if (nOpens > 0) {
                    nOpens--;
                } else {
                    minAdd++;
                }
            }
        }
        minAdd += nOpens;
        return minAdd;
    }

    static int AreaRec(int[] nums) {
        int max = 0;
        Stack<Integer> dsa = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dsa.isEmpty() && nums[i] < nums[dsa.peek()]) {
                int h = nums[dsa.pop()];
                int w = dsa.isEmpty() ? i : i - dsa.peek() - 1;
                int area = h * w;
                max = Math.max(max, area);
            }
            dsa.push(i);
        }
        while (!dsa.isEmpty()) {
            int h = nums[dsa.pop()];
            int w = dsa.isEmpty() ? nums.length : nums.length - dsa.peek() - 1;
            int area = h * w;
            max = Math.max(max, area);
        }
        return max;
    }
}

class MinStack {
    Stack<Integer> main;
    Stack<Integer> minstack;

    MinStack() {
        main = new Stack<>();
        minstack = new Stack<>();
    }

    void push(int data) {
        main.push(data);
        if (minstack.isEmpty() || data <= minstack.peek()) {
            minstack.push(data);
        }
    }

    int pop() {
        if (main.peek().equals(minstack.peek())) {
            minstack.pop();
        }
        return main.pop();
    }

    int peek() {
        return main.peek();
    }

    int getMin() {
        return minstack.peek();
    }
}

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> reversestack;

    public MyQueue() {
        stack = new Stack<>();
        reversestack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        populate();
    }

    private void populate() {
        reversestack = new Stack<>();
        while (!stack.isEmpty()) {
            reversestack.push(stack.pop());
        }
    }

    public int pop() {
        return reversestack.pop();
    }

    public int peek() {
        return reversestack.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && reversestack.isEmpty();
    }
}

class StackLL {
    static class StackNode {
        int data;
        StackNode next;

        StackNode(int value) {
            this.data = value;
            this.next = null;
        }
    }

    private StackNode head = null;
    private StackNode tail = null;

    boolean isEmpty() {
        return head == null;
    }

    void push(int value) {
        if (isEmpty()) {
            head = new StackNode(value);
            tail = head;
        } else {
            StackNode n = new StackNode(value);
            tail.next = n;
            tail = n;
        }
    }

    int pop() {
        if (isEmpty()) return -1;
        else {
            if (head == tail) {
                int popped = head.data;
                head = null;
                tail = null;
                return popped;
            }
            StackNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            int popped = current.next.data;
            tail = current;
            tail.next = null;
            return popped;
        }
    }

    int peek() {
        if (isEmpty()) return -1;
        else return tail.data;
    }

    void print() {
        StackNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //Input: nums = [4,5,6,7,0,1,2], target = 0
    //Output: 4
    public int search(int[] array, int target) {
        if (array[array.length - 1] > target) {
            for (int i = array.length - 1; i >= array[array.length - 1] + 1; i--) {
                if (array[i] == target) return i;
            }
        } else if (array[array.length - 1] < target) {
            for (int i = 0; i <= array.length - array[array.length - 1] + 1; i++) {
                if (array[i] == target) return i;
            }
        } else return array.length - 1;
        return -1;
    }


    public static void main(String[] args) {
//        MyQueue q = new MyQueue();
//        q.push(1);
//        q.push(3);
//        q.push(4);
//        q.push(0);
//        q.push(10);
//        System.out.println(q.peek());
        StackLL sl = new StackLL();
        System.out.println("At start stack will be empty:" + sl.isEmpty());
        System.out.println("Peek at start will give -1: " + sl.peek());
        sl.push(1);
        sl.push(10);
        sl.push(4);
        sl.push(3);
        sl.print();
        System.out.println("Popped: " + sl.pop());
        sl.print();

        Stack<Integer> st = new Stack<>();
    }
}

//implementing stack using queue
class MyStack {

    //void push(int x) Pushes element x to the top of the stack.
    //int pop() Removes the element on the top of the stack and returns it.
    //int top() Returns the element on the top of the stack.
    //boolean empty() Returns true if the stack is empty, false otherwise.

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int element) {
        if (q1.isEmpty()) q1.offer(element);
        else {
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            q1.offer(element);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }
    }

    public int pop() {
        if (q1.isEmpty()) return -1;
        else return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) return -1;
        else return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

class Minstack {
    //MinStack() initializes the stack object.
    //void push(int val) pushes the element val onto the stack.
    //void pop() removes the element on the top of the stack.
    //int top() gets the top element of the stack.
    //int getMin() retrieves the minimum element in the stack.

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Minstack() {
        stack1= new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if (stack2.isEmpty()){
            stack1.push(val);
            stack2.push(val);
        }
        else {
            if (val<stack2.peek()){
                stack2.pop();
                stack2.push(val);
                stack1.push(val);
            }
            else stack1.push(val);
        }
    }

    public void pop() {
        if (stack1.isEmpty()) System.out.println(-1);
        else {
            if (!stack2.isEmpty() && stack1.peek().equals(stack2.peek())){
                stack2.pop();
                System.out.println(stack1.pop());
            }
            else System.out.println(stack1.pop());
        }
    }

    public int top() {
        if (stack1.isEmpty()) return -1;
        else return stack1.peek();
    }

    public int getMin() {
        if (stack2.isEmpty()) return -1;
        else return stack2.pop();
    }
}
 class triangle_DT {
public static void main(String[] args) {
	System.out.println("\n Enter 3 integers which are sides of triangle\n");
	Scanner in = new Scanner(System.in);
	int a = in.nextInt();
	int b = in.nextInt();
	int c = in.nextInt();
	in.close();

	if(a<b+c && b<a+c && c<a+b)
	{
	System.out.println("triangle can be formed");
	if((a==b) && (b==c))
		System.out.println("equilateral triangle");
	else if((a!=b) && (a!=c) && (b!=c))
		System.out.println("scalene triangle");
	else
		System.out.println("isosceles triangle");
	}
	else
		System.out.println("triangle cannot be formed");
	}
}

