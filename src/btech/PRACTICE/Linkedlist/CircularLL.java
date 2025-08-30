package JAVA.PRACTICE.Linkedlist;

class CircularLL {
    private  Node head;
    private Node tail;
    int size;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void insertFirst(int data){
        Node node = new Node(data);
        if ( head == null){
            tail=node;
            head = node;
            return;
        }
        node.next= head;
        tail.next = node;
        tail = node;
        size++;
    }
     Node find ( int val){
        Node node = new Node(val);
        if ( node.data == val){
            return node;
        }
        return node;
    }
    public void delete(int data){}
    void display(){
        Node node = head;
        if  ( head == null) System.out.println(" Empty ");
        else {
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            }while (node!= head);
            System.out.println("End");
        }
    }
    public static void main(String[] args){
        CircularLL cll = new CircularLL();
        cll.insertFirst(4);
        cll.insertFirst(5);
        cll.insertFirst(7);
        cll.display();
    }
}
