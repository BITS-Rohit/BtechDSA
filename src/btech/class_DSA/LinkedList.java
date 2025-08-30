package JAVA.class_DSA;

class LinkedList {
    static Node head;

    private static class Node{
        int data;
        Node next;
        Node(int value){
            this.data=value;
            this.next=null;
        }
    }
    static void Create(int value){
        Node node = new Node(value);
        if (head ==null ){
            head = node;
            return;
        }
        node.next =head;
        head=node;
    }
    static void insertLast(int value){
        Node node =new Node(value);
        if (head ==null){
            head=node;
        }
        Node current= head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=node;
    }

    static void display(){
        if ( head == null){
            System.out.println("Empty Linked List ...");
        }
        Node print =head;
        while(print!=null){
            System.out.print(print.data+" ----> ");
            print=print.next;
        }
        System.out.print("End");
    }
    public static void main(String[] args){
        Create(25);
        Create(24);
        Create(23);
        Create(23);
        Create(22);
        Create(21);
        display();
        System.out.println(" \n After the insert last linked list is : ");
        insertLast(10);
        insertLast(1);
        display();
    }
}
