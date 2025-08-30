package btech.revision;

public class DoublyNodes {
    static class Node{
        int data;
        Node next;
        Node pre;
        Node(int value){
            this.data=value;
            this.next=null;
            this.pre=null;
        }
    }
    static Node head;
    static void first(int value){
        Node node = new Node (value);
        if (head==null){
            head=node;
        }
        node.next=head;
        head.pre=node;
        head=node;
    }
    static void Last(int value){
        Node node = new Node (value);
        if (head == null ){
            head = node;
        }
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=node;
        node.pre=current;
        node.next=null;
    }
    static void print(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("End");
    }

    static void insert(int value, int pos){
        Node node = new Node(value);
        if (head== null){
            head=node;
        }
        Node current = head;
        int size =1;
        while(current.next!=null){
            if (size+1==pos){
                node.next = current.next;
                node.pre = current;
                current.next=node;
                size++;
            }
            current=current.next;
            size++;
        }
    }
    static void revDisplay(){
        revNode(head);
        System.out.println("start");
    }

    static void update(int value, int pos){

        Node current = head;
        int size =1;
        if (current!=null){
            while(current!=null){
                if(size+1==pos){
                    current.next.data=value;
                }
                current=current.next;
                size++;
            }
        }
    }
    private static void revNode(Node node) {
        if (node==null){
            return;
        }
        revNode(node.next);
        System.out.print(node.data+" <-- ");
    }

    static void delete(int value){
        Node current = head;
        while(current.next!=null){
            if (current.next.data==value){
                current.next=current.next.next;
            }
//            else System.out.println("Data Not Found");
            current=current.next;
        }
    }

    static void delPos(int pos){
        int size =1 ;
        Node current = head;

        if (pos<size) System.out.println("Invalid Position");

        while ( current!=null){
            if (size+1==pos){
                current.next=current.next.next;
            }
//            else System.out.println("Position Not Found");
            current=current.next;
            size++;
        }
    }
    public static void main(String[] args) {
        Last(10);
        Last(20);
        Last(40);
        print();
        insert(30,3);
        print();
//        delete(30);
//        print();
//        delPos(3);
//        print();
//        revDisplay();
        update(400,4);
        System.out.println("updated:");
        System.out.println();
        print();

    }
}
