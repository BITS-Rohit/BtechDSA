package Code;

import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class QueueStructure implements Serializable {
    public static void main(String[] args) {
        System.out.println();
//        QueueArray qarray = new QueueArray();
//        qarray.insert(23);
//        qarray.insert(2);
//        qarray.insert(4);
//        qarray.insert(55);
//        qarray.insert(-100);
//
//        System.out.println("Size is 10 so it is full ?(expected yno ) "+qarray.isFull());
//        System.out.println("Size is 10 so it is empty(Expected no) ? "+qarray.isEmpty());
//
//        System.out.println("Peek: "+qarray.peek());
//        System.out.println("Deleted Element: "+qarray.remove());
//        System.out.println("Peek: "+qarray.peek());

//        QueueLinkedList ql = new QueueLinkedList();
//        ql.insert(12);
//        ql.insert(4);
//        ql.insert(2);
//        ql.insert(1);

//        System.out.println("peek: "+ql.peek());
//        System.out.println("delete: "+ql.delete());
//
//        System.out.println("peek: "+ql.peek());
//        System.out.println("delete: "+ql.delete());
//
//        System.out.println("peek: "+ql.peek());
//        System.out.println("delete: "+ql.delete());

//        CirCularLinkedListQueue cql = new CirCularLinkedListQueue(5);
//        cql.insert(23);
//        cql.insert(45);
//        cql.insert(3);
//        cql.insert(2);
//        cql.insert(5);
//        cql.insert(1);
//
//        System.out.print("Circuar Queue: ");
//        cql.show();
//
//        System.out.println("Peek: "+cql.top());
//        System.out.println("Deleted: "+cql.remove());
//
//        System.out.println("Peek: "+cql.top());
//        System.out.println("Deleted: "+cql.remove());
//
//        System.out.println("Peek: "+cql.top());
//        System.out.println("Deleted: "+cql.remove());
//
//        System.out.println("Peek: "+cql.top());
//        System.out.println("Deleted: "+cql.remove());
//
//        System.out.println("Peek: "+cql.top());
//        System.out.println("Deleted: "+cql.remove());

//        DequeArray dr = new DequeArray(5);
//
//        System.out.println("Front Empty(exp: yes): " + dr.isFrontEmpty());
//        System.out.println("Rear Empty(exp: yes): " + dr.isRearEmpty());
//
//        dr.FrontAdd(10);
//        dr.FrontAdd(20);
//
//        dr.RearAdd(100);
//        dr.RearAdd(200);
//
//        dr.ShowCase();
//        System.out.println("Size: " + dr.getCurrentSize());
//        System.out.print("Array: ");
//        dr.ShowArray();
//
//        System.out.println("After Resize");
//        dr.resize();
//        dr.ShowCase();
//        System.out.println("Array: ");
//        dr.ShowArray();
//        System.out.println("Rear: "+dr.getRearidx());
//
//        System.out.println("Array at current Rear: "+dr.getArrayEle(dr.getRearidx()));

//        QueueStructure qs = new QueueStructure();
//        System.out.println(qs.palindromecheck("racecar"));

        QueueStructure q = new QueueStructure();
        Deque<Integer> d = new LinkedList<>();
        d.addLast(23);
        d.addLast(24);
        d.addLast(25);
//        d.addFirst(34);
//        d.addFirst(4);
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        System.out.println(d);
//        System.out.println(Arrays.toString(q.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
//System.out.println(Arrays.toString(q.maxSlidingWindow(new int[]{5, 5, 5, 5, 5}, 2)));
// Expected output: [5, 5, 5, 5]
//
// Test case with a window size of 1 (each window is a single element)
//System.out.println(Arrays.toString(q.maxSlidingWindow(new int[]{9, -2, 3, 7, 8, 2}, 1)));
// Expected output: [9, -2, 3, 7, 8, 2]
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Intermediate Questions:

    // Reverse a Queue
    void reverse(Queue<Integer> q){
        if(q.isEmpty()) System.out.println("Process Done");
        else {
            int f = q.poll();
            reverse(q);
            q.offer(f);
        }
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[arr.length-k+1];
        for (int i = 0; i < arr.length; i++) {
            while(!queue.isEmpty() && arr[queue.peekLast()]<arr[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if(queue.getFirst()+k ==i){
                queue.removeFirst();
            }
            if (i>=k-1){
                res[i-k+1]=arr[queue.getFirst()];
            }
        }
        return res;
    }
    boolean palindromecheck(String string){
        Queue<Character> dq = new ArrayDeque<>(string.length());
        for(char ch : string.toCharArray()){
            dq.add(ch);
        }
        for (int i = string.length()-1; i >0; i--) {
            if(string.charAt(i)!= dq.remove())return false;
        }
        return true;
    }

    void revatK(Queue<Integer> q , int k ){

    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class MyCircularQueue {

    //MyCircularQueue(k) Initializes the object with the size of the queue to be k.
    //int Front() Gets the front item from the queue. If the queue is empty, return -1.
    //int Rear() Gets the last item from the queue. If the queue is empty, return -1.
    //boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
    //boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
    //boolean isEmpty() Checks whether the circular queue is empty or not.
    //boolean isFull() Checks whether the circular queue is full or not.

    private final int[] array;
    private int size;
    private int Front;
    private int Rear;

    public MyCircularQueue(int k) {
        this.array=new int[k];
        this.size=0;
        this.Front=0;
        this.Rear=-1;
    }

    public boolean enQueue(int value) {
        if(!isfilled()){
            Rear=(Rear+1)%array.length;
            array[Rear]=value;
            size++;
            return true;
        }
        else return false;
    }

    public boolean deQueue() {
        if(size>0){
            Front=(Front+1)%array.length;
            size--;
            return true;
        }
        else return false;
    }

    public int Front() {
        if(isEmpty())return -1;
        else return array[Front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        else return array[Rear];
    }

    public boolean isEmpty() {
        return size==0;
    }

    boolean isfilled() {
        return size==array.length;
    }
}

class Stack2Queues{
    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    Stack2Queues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    void push(int element){
        if (q1.isEmpty())q1.offer(element);
        else {
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }
            q1.offer(element);
            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
    }

    int pop(){
        if(q1.isEmpty())return -1;
        else return q1.poll();
    }
    int peek(){
        if(q1.isEmpty())return -1;
        else return q1.peek();
    }
}

class Stack1Queues{
    private final Queue<Integer>push;

    Stack1Queues(){
        this.push=new LinkedList<>();
    }

    int size(){return push.size();}

    void push(int n){
        push.offer(n);
        for (int i = 0; i < size() - 1; i++) {
            push.offer(push.poll());
        }
    }

    int pop(){
        if(push.isEmpty())return -1;
        else return push.poll();
    }

    int peek(){
        if(push.isEmpty())return -1;
        else return push.element();
    }
}

class QueueArray {
    private final int QSize;
    private final int[] Array;
    private int IDX = 0;
    private int Top = 0;

    QueueArray() {
        this.QSize = 10;
        this.Array = new int[QSize];
    }

    QueueArray(int initialCapacity) {
        this.QSize = initialCapacity;
        this.Array = new int[QSize];
    }

    boolean isEmpty() {
        return IDX == 0;
    }

    boolean isFull() {
        return IDX == QSize;
    }

    void insert(int element) {
        if (isFull()) System.out.println("OverFlow");
        else Array[IDX] = element;
        IDX++;
    }

    int remove() {
        if (isEmpty()) return -1;
        else {
            return Array[Top++];
        }
    }

    int peek() {
        if (isEmpty()) return -1;
        else return Array[Top];
    }
}

class QueueLinkedList {
    static class Node {

        private final int Data;
        private Node next;

        Node(int value) {
            this.Data = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node Top;

    boolean isEmpty() {
        return head == null;
    }

    boolean isFull() {
        return tail == null;
    }

    void insert(int n) {
        if (isEmpty()) {
            head = new Node(n);
            tail = head;
            Top = head;
        } else {
            Node newnode = new Node(n);
            tail.next = newnode;
            tail = newnode;
        }
    }

    int delete() {
        if (isEmpty()) return Integer.MIN_VALUE;
        else if (head.Data == Top.Data) {
            int ele = Top.Data;
            head = head.next;
            Top = Top.next;
            return ele;
        }
        return -1;
    }

    int peek() {
        if (isEmpty()) return Integer.MIN_VALUE;
        else return Top.Data;
    }
}

class CirCularLinkedListQueue {
    static class node {

        private int Data;
        private node next;

        node(int value) {
            this.Data = value;
            this.next = null;
        }
    }

    private final int DefaultSize;
    private node head;
    private int idx = 0;
    private node tail;

    CirCularLinkedListQueue() {
        this.DefaultSize = 10;
        head = null;
        tail = null;
    }

    CirCularLinkedListQueue(int initialCapacity) {
        this.DefaultSize = initialCapacity;
    }

    boolean isEmpty() {
        return head == null;
    }

    boolean isFull() {
        return idx == DefaultSize;
    }

    void insert(int element) {
        node newNode = new node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else if (isFull()) {
            head.Data = element;
            head = head.next;
            tail = tail.next;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            idx++;
        }
    }

    int remove() {
        if (isEmpty()) return Integer.MIN_VALUE;
        else {
            int ele = head.Data;
            if (head == tail) head = tail = null;
            else {
                head = head.next;
                tail.next = head;
            }
            return ele;
        }
    }

    int top() {
        if (isEmpty()) return Integer.MIN_VALUE;
        return head.Data;
    }

    void show() {
        if (isEmpty()) System.out.println("Queue is Empty");
        else {
            node current = head;
            System.out.print("Head ->");
            while (current.next != head) {
                System.out.print(" -> " + current.Data);
                current = current.next;
            }
            System.out.print(" -> " + current.Data);
            System.out.println(" -> -> Head ");
        }
    }
}

class DequeArray {
    private int[] Array;
    private int SIZE;
    private int Front;
    private int Rear;


    DequeArray() {
        this.SIZE = 5;
        this.Array = new int[SIZE];
        Array = IntStream.generate(() -> Integer.MIN_VALUE).limit(Array.length).toArray();

        Front = -1;
        Rear = Array.length;
        // comcept behind it for using front as -1 and rear as arr.length is that
        // when we add the element these pointers will be on the same element as the new element is added
        // + these guys will now also giving correct non-error-prone concept for the front and rear empty
    }

    DequeArray(int initialCapacity) {
        this.SIZE = initialCapacity;
        this.Array = new int[SIZE];
        Front = -1;
        Rear = Array.length;
        Array = IntStream.generate(() -> Integer.MIN_VALUE).limit(Array.length).toArray();
    }

    boolean isFull() {
        return Front + 1 == Rear;
    }

    boolean isFrontEmpty() {
        return Front == -1;
    }

    boolean isRearEmpty() {
        return Rear == Array.length;
    }

    void resize() {
        int len = SIZE;
        SIZE *= 2;
        int[] resized = new int[SIZE];
        int last = resized.length-1;
        if (!isFrontEmpty()) {           // Front Adding
            if (Front + 1 >= 0) System.arraycopy(Array, 0, resized, 0, Front + 1);
        }
        if (!isRearEmpty()) {             // Rear Adding
            for (int i = Array.length - 1; i >= Rear; i--) {
                resized[last--]=Array[i];
            }
        }
        if (Front + 1 < Rear) {              // Space between Front and Rear
            for (int i = Front + 1; i <= last; i++) {
                resized[i]=Integer.MIN_VALUE;
            }
        }
        Array=resized;          // Update Array
        Rear=++last;            //Rear Update
    }

    int getRearidx(){return Rear;}          // get rear idx

    int getFrontidx(){return Front;}        // get rear idx

    void FrontAdd(int element) {
        if (isFull()) System.out.println("Arrays is full");   // Check nullability
        else Array[++Front] = element;
    }

    void RearAdd(int element) {
        if (isFull()) System.out.println("Arrays is full");   // Check nullability
        else Array[--Rear] = element;
    }

    void Frontremove() {
        if (isFrontEmpty()) System.out.println("Empty Front");
        else {
            int ele = Array[Front];
            Array[Front] = Integer.MIN_VALUE;
            Front--;
        }
    }

    void Rearremove() {
        if (isRearEmpty()) System.out.println("Empty Rear");
        else {
            int ele = Array[Rear];
            Array[Rear] = Integer.MIN_VALUE;
            Rear++;
        }
    }

    int getFront() {
        return Array[Front];
    }

    int getRear() {
        return Array[Rear];
    }

    int getCurrentSize() {
        return SIZE;
    }

    void ShowCase() {
        int last=Front+1;
        if (isFrontEmpty()) System.out.println("Front: Empty");
        else {
            System.out.print("\nFront:");
            for (int i = 0; i <= Front; i++) {
                System.out.print(" " + Array[i]);
            }
        }
        if (Front+1 < Rear) {
            System.out.print("\nSpace:");
            while(Array[last]==Integer.MIN_VALUE){
                System.out.print(" "+Array[last]);
                last++;
            }
        } else System.out.println("Space: Empty");

        if (isRearEmpty()) System.out.println("Rear: Empty");
        else {
            System.out.print("\nRear: ");
            for (int i = Array.length - 1; i >= last; i--) {
                System.out.print(" " + Array[i]);
            }
        }
        System.out.println();
    }

    void ShowArray() {
        System.out.println(Arrays.toString(Array));
    }

    int getArrayEle(int idx){
        if(idx<SIZE)return Array[idx];
        else return Integer.MIN_VALUE;
    }
}

class DequeDoublyLinkedList{
    static class Node{
        private int val;
        private Node next;
        private Node prev;

        Node(){}
        Node(int val){
            this.val=val;
            next = prev = null;
        }
    }

    // Here we will do dynamic allocation
    // so there will not be an isfull condition
    // Also there will be no size limitation

    private Node head;
    private Node tail;
    private int size=0;

    DequeDoublyLinkedList(){
        head=tail=null;
    }

    boolean isEmpty(){
        return head==tail || size==0;
    }

    void insertFirst(int val){
        if (isEmpty()){
            head= new Node(val);
            tail=head;
        }
        else {
            Node newnode = new Node(val);
            head.prev=newnode;
            newnode.next=head;
            head=newnode;
        }
        size++;
    }

    void insertLast(int val){
        if (isEmpty()){
            head= new Node(val);
            tail=head;
        }
        else {
            Node newnode = new Node(val);
            newnode.prev=tail;
            tail.next=newnode;
            tail=newnode;
        }
        size++;
    }

    int removelast(){
        if (isEmpty())return Integer.MIN_VALUE;
        else {
            int ele = tail.val;
            tail=tail.prev;
            tail.next=null;
            size--;
            return ele;
        }
    }

    int removefirst(){
        if(isEmpty())return Integer.MIN_VALUE;
        else {
            int ele=head.val;
            head=head.next;
            head.prev=null;
            size--;
            return ele;
        }
    }

    int peekFront(){
        if(isEmpty())return Integer.MIN_VALUE;
        else return head.val;
    }

    int peekLast(){
        if(isEmpty()) return Integer.MIN_VALUE;
        else return tail.val;
    }

    int getSize(){return size;}
}

class QueueUsingStack{
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    void add( Integer ele){
        if (stack1.isEmpty()) stack1.push(ele);
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    int element(){
        if(stack2.isEmpty())return -1;
        else return stack2.pop();
    }

    int front(){
        if(stack2.isEmpty())return -1;
        else return stack2.peek();
    }
}