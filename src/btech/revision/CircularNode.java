package JAVA.revision;

public class CircularNode {
    static class Node{
        int data;
        Node next;
        Node(int value){
            this.data=value;
            this.next=null;
        }
    }
    static Node head;
    static Node tail;

    static void insert(int value,int pos){
        Node node = new Node(value);
        if (pos<=0) System.out.println("Invalid position");
        if (head==null){
            head=node;
            tail=node;
            return;
        }
        if (pos==1){
            node.next=head;
            tail.next=node;
            head=node;
            return;
        }
        int size = 1;
        Node current=head;
        while(current.next!=head ){
            if (size+1==pos){
                node.next=current.next;
                current.next=node;
            }
            current=current.next;
            size++;
        }
        node.next=head;
        tail.next=node;
        tail=node;
    }

    static void delValue(int value){
        if (head==null) {
            System.out.println("Empty List");
            return;
        }
        if (head.data==value){
            head=head.next;
            return;
        }
        Node current = head;
        while(current.next!=head){
            if (current.next.data==value){
                current.next=current.next.next;
            }
            current=current.next;
        }
    }

    static void delPos(int pos){
        if (head == null){
            System.out.println("Empty List");
            return;
        }
        if (pos<=0) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos==1){
            head=head.next;
            return;
        }
        Node current = head;
        int size=1;
        while(current.next!=head){
            if (size+1==pos){
                current.next=current.next.next;
                return;
            }
            current=current.next;
            size++;
        }
    }

    static void update(int value, int pos){
        if (head==null){
            System.out.println("Empty");
            return;
        }
        if (pos==1){
            head.data=value;
        }
        if (pos<=0) {
            System.out.println("Invalid Position ");
            return;
        }
        int size =1;
        Node current = head;
        while (current.next!=head){
            if (size==pos){
                current.data=value;
                return;
            }
            current=current.next;
            size++;
        }
    }

    static void print(){
        if (head==null) System.out.println("Empty");
        Node current = head;
        do {
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        while(current!=head);
        System.out.println("End");
    }

    static void revDisplay(){
        Rev(head);
        System.out.println("Start");
    }

    private static void Rev(Node node) {
        if (node.next==head){
            System.out.print(node.data+" <- ");
            return;
        }
        Rev(node.next);
        System.out.print(node.data+" <- ");
    }

    public static void main(String[] args) {
        insert(20,2);
        insert(10,1);
        insert(30,3);
        insert(40,4);
        print();
        update(200,2);
        print();
//        revDisplay();
    }
}
