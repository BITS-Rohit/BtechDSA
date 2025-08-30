package JAVA.PRACTICE.Linkedlist;

public class LL1 {
    private Node head;
    static class Node {
        String data;
        Node next ;
        Node(String data){
            this.data = data;
            this.next=null;
        }
    }
    public void add_1st(String data){
        Node new_n = new Node(data);
        if ( head == null ){
            head = new_n;
            return;
        }
        new_n.next= head;
        head = new_n;
    }
    public void InsertLst(String  data){
        Node newnode =new Node(data);
        if ( head == null){
            head=newnode;
            return;
        }
        Node current = head;
        while (current.next!=null){
            current= current.next;
        }
//        current.next= newnode;
    }
    public  void print (){
        if ( head == null ){
        }
    }
    public static void main(String[] args){
    LL1 l = new LL1();
    l.add_1st("23");
    l.add_1st("23");
    l.add_1st("23");
    l.print();
    }
}
