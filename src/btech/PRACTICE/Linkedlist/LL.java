package JAVA.PRACTICE.Linkedlist;
//
//public class LL {
//    Node head;
//     Node tail;
//     int size;
//    public LL(){
//        this.size = 0;
//    }
//    public void insert1st(int value){
//        Node node =new Node(value);
//        node.next= head;
//        head=node;
//         if ( tail == null){
//             tail= head;
//         }
//         size++;
//    }
//    public void insertLast(int value){
//        if ( tail ==null ){
//            insertLast(value);
//            return;
//        }
//        Node node = new Node(value);
//        tail.next= node;
//        tail= node;
//        size++;
//    }
//    public void display(){
//         Node temp = head;
//         while(temp!=null) {
//             System.out.print(temp.value+" --> ");
//             temp=temp.next;
//         }
//         System.out.println("ENDING");
//
//    }
//    private static class Node {
//         Node next;
//         int value;
//
//        public Node(int value ){this.value=value;}
//    }
//
//    public static void main(String[] args) {
//        LL n =new LL();
//        n.insert1st(1);
//        n.insert1st(3);
//        n.insert1st(4);
//        n.insert1st(6);
//        n.display();
//    }
//
//}
//

class LL{
    private Node head;

    static class Node {
        String data;
        Node tail;
        Node next;
        int size;

        int val;
        Node(String data){
            this.data = data;
            this.next = null;
        }

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }
    public void add_first(String  data){
        Node NN = new Node(data);
        if (head  == null){
            head=NN;
            return;
        }
        NN.next = head;
        head = NN;
    }
    public void add_last(String data){
        Node newnode = new Node(data);
        if ( head ==null){
            head= newnode;
            return;
        }
        Node currnode = head;
        while (currnode.next!=null){
            currnode=currnode.next;
        }
        currnode.next = newnode;
    }
    public void print(){
        if ( head == null) System.out.println(" List is ended ");
        Node currentnode = head;
        while (currentnode!=null){
            System.out.println(currentnode.data);
            currentnode= currentnode.next;
        }
        System.out.println("Null");
    }
    void insertRec( int val, int index){

    }
    Node insertRec ( int index , int val, Node node){
        if ( index==0){
            Node currnode = new Node ( val,node);

        }
        return insertRec(index--,val,node.next);
    }
    public static void main(String[] args){
        LL l = new LL();
        l.add_first("34");
        l.add_first("3");
        l.add_first("4");
        l.add_last("wow");
        l.add_last("LOL");
        l.add_last("MOTh");

        l.print();
    }
}
