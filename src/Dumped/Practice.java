package Dumped;

import java.util.EmptyStackException;

class Node {
    int data;
    Node next;

    Node() {
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SL {
    //Singly LinkedList
    private Node head = null;

    void insert(int data) {
        if (head == null) head = new Node(data);
        else {
            Node n = new Node(data);
            n.next = head;
            head = n;
        }
    }

    void delete() {  //for reference will delete it at the start
        if (head == null) throw new EmptyStackException();
        else head = head.next;
    }

    void updation(int target, int update) {
        if (head == null) throw new EmptyStackException();
        else {
            Node c = head;
            while (c != null) {
                if (c.data == target) {
                    c.data = update;
                    break;
                }
                c = c.next;
            }
        }
    }
}

class DL {
    //Double LinkedList
    static class node {
        int data;
        node next;
        node prev;

        public node(int data) {
            this.next = null;
            this.prev = null;
        }
    }

    private node head = null;

    void insert(int data) {
        if (head == null) head = new node(data);
        else {
            node n = new node(data);
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    void delete(int data) {
        if (head == null) throw new EmptyStackException();
        else head = head.next;
    }

    void update(int target, int update) {
        if (head == null) throw new EmptyStackException();
        else {
            node n = head;
            while (n != null) {
                if (n.data == target) n.data = update;
                n = n.next;
            }
        }
    }
}

class CL {
    private Node front = null;
    private Node rear = null;

    void insert(int data) {
        if (front == null) {
            front = rear = new Node(data);
            front.next = rear;
        } else {
            Node n = new Node(data);
            n.next = front;
            front = n;
        }
    }

    void delete() {
        if (front == null) throw new EmptyStackException();
        else front = front.next;
    }

    void update(int target, int update) {
        if (front == null) throw new EmptyStackException();
        else {
            Node n = front;
            while (n != null) {
                if (n.data == target) n.data = update;
                n = n.next;
            }
        }
    }
}

class StackLL {
    private int DS;
    private int Top = 0;
    private final int[] arr;

    StackLL() {
        arr = new int[DS];
    }

    StackLL(int size) {
        DS = size;
        arr = new int[size];
    }

    void add(int data) {
        if (Top != DS) arr[Top++] = data;
        else System.out.println("Stack Overflow");
    }

    void pop() {
        if (Top != 0) System.out.println(arr[Top--]);
        else System.out.println("Stack Underflow");
    }

    void peek() {
        if (Top != 0) System.out.println(arr[Top]);
        else System.out.println("Stack Underflow");
    }
}

class Queue {

}

class MinHeap {
    private int size;
    private int maxS;
    private int[] heap;

    MinHeap(int capacity) {
        this.size = 0;
        this.maxS = capacity;
        heap = new int[maxS];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int lchild(int pos) {
        return (2 * pos) + 1;
    }

    private int rchild(int pos) {
        return (2 * pos) + 2;
    }

    private void swap(int left, int right) {
        int temp = heap[left];
        heap[left] = heap[right];
        heap[right] = temp;
    }

    void heapify(int pos) {
        int small = pos;
        int l = lchild(pos);
        int r = rchild(pos);

        if (l < size && heap[l] < heap[small]) small = l;
        if (r < size && heap[r] < heap[small]) small = r;

        if (small != pos) {
            swap(pos, small);
            heapify(small);
        }
    }

    void insert(int ele) {
        if (size >= maxS) System.out.println("Heap is Full");
        else {
            heap[size] = ele;
            int c = size;
            size++;
            while (c > 0 && heap[c] < heap[parent(c)]) {
                swap(c, parent(c));
                c = parent(c);
            }
        }
    }

    int remove() {
        if (size <= 0) return -1;
        int r = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return r;
    }

}