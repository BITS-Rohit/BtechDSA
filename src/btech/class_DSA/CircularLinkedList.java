package JAVA.class_DSA;

class CircularLinkedList {
    private static class Node{
        Node next;
        int data;
        Node(int value){
            this.data=value;
            this.next=null;
        }
    }
    private static Node head;
    private static Node tail;

    static void first(int value ){
        Node node = new Node(value);
        if (head== null){
            head=node;
            tail=node;
            return;
        }
        node.next=head;
        tail.next=node;
        head=node;
    }

   static void delete(int value){
        Node node = new Node(value);
        if ( head == null) {
            System.out.println("Empty Circular Linked List...");
            return;
        }
        if ( node.data==value){
            head=head.next;
            tail.next=head;
            return;
        }
        Node current = head;
        while(current.next!=head){
            if (current.next.data==value){
                current=current.next.next;
            }
            current=current.next;
        }
   }
    static void display(){
        Node  current = head;
        if ( head != null) {
            do {
                System.out.print(current.data+" --> ");
                current=current.next;
            }
            while (current.next!=head);
            System.out.println("Head");
        }
        else System.out.println("Empty Circular Linked List...");
    }
    public static void main(String[] args){
        first(20);
        first(21);
        first(22);
        first(23);
        first(30);
        first(25);
        display();
        System.out.println("\n \n After deleting 30 from list ");
        delete(30);
        display();
    }
}
