package JAVA.class_DSA;

class DoublyLinkedList {
    private static class Node{
        int value;
        Node next ;
        Node prev;
        Node(int val){
            this.value=val;
            this.next=null;
            this.prev=null;
        }
    }
    static Node head;
    static Node tail;
    static int size;
    static void create(int val){
        Node node = new Node(val);
        if( head== null){
            tail= node;
            head=node;
            size++;
            return;
        }
        head.prev=node;
        node.next=head;
        head=node;
        size++;
    }

    static void insertLast(int val){
        Node node = new Node(val);
        if( head== null){
            create(val);
            return;
        }
        tail.next=node;
        node.prev=tail;
        tail=node;
        size++;
    }
    static void insert(int val){
        if ( head == null ){
            create(val);
            return;
        }
        Node current = head;

    }

    static void display(){
        if ( head == null){
            System.out.println("Linked List is Empty");
        }
        Node current= head;
        while(current!=null){
            System.out.print(current.value+" --> ");
            current=current.next;
        }
        System.out.println("End");
    }
    public static void main(String[] args){
        create(20);
        create(19);
        display();
        System.out.println("\n \n After Inserting mor elements in last : \n \n ");
        insertLast(100);
        insertLast(90);
        display();
    }
}
