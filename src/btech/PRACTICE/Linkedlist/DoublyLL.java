package JAVA.PRACTICE.Linkedlist;

public class DoublyLL {
    private Node head;
    int size;
    static class Node {
        Node prev;
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void insertFirst(int data){
        Node newnode = new Node(data);
        if ( head == null ){
            head=newnode;
            return;
        }
        head.prev = newnode;
        newnode.next=head;
        newnode.prev= null;
        head=newnode;
        size ++;
    }
    public void insertLast(int data){
        Node node = new Node(data);
        if ( head == null ){
            node.prev = null;
            head = node ;
            return;
        }
        Node last = head;
        while( last.next!= null){
            last=last.next;
        }
        last.next= node;
        node.prev=last;
        node.next=null;
        size++;
    }
    public void display(){
        if ( head == null) {
            System.out.println(" List is empty ");
            return;
        }
        Node currnode = head;
        Node last = null;
        while(currnode!=null){
            System.out.print(currnode.data+ " -->> ");
            last= currnode;
            currnode=currnode.next;
        }
        System.out.println(" !!!End!!! ");

        System.out.println(" Print in reverse !!! ");

        while ( last !=  null){
            System.out.print(last.data + " -->> ");
            last = last.prev;
        }
        System.out.println(" !!!End!!! ");
    }

    public static void main(String[] args){
        DoublyLL dll = new DoublyLL();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.display();
        System.out.println("After last insert in node ");
        dll.insertLast(22);
        dll.insertLast(11);
        dll.display();
    }
}
