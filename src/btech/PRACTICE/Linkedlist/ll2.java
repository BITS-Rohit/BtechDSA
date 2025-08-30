package JAVA.PRACTICE.Linkedlist;

class ll2 {
    Node head;
    Node tail;
    int size;
    ll2(){
        this.size=0;
    }

    static class Node{
        int data;

        Node next;
        Node(int data){
            this.data= data;
            this.next= null;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public void insertFirst(int data){
        Node newnode = new Node(data);
        if ( head == null ){
            head = newnode;
            return;
        }
        newnode.next= head;
        head= newnode;
        size++;
    }
    public void insertLast(int data){
        if ( tail ==null){
            insertFirst(data);
            return;
        }
        Node currnode = new Node( data);
        tail.next= currnode;
        tail = currnode;
        size++;
    }
    public void insert(int data, int index){
        if ( index==0)
        {
            insertFirst(data);
            return;
        }
        if ( index == size) {
            insertLast(data);
            return;}
        Node temp = head;
        for (int i=1; i< index; i++) {temp = temp.next;}
        temp.next= new Node(data, temp.next);
        size++;
    }
    public void deleteFirst(){
        if ( head == null) {
            tail=null;
            System.out.println(" List is Empty ");
            return;
        }
        int v = head.data;
        head = head.next;
        size--;
        System.out.println("Deleted Item : "+v);
    }
    public Node get (int index){
        Node node = head;
        for (int i=0;i< index ; i++){
            node = node.next;
        }
        return node;
    }
    public void deleteLast()
    {
        if (size<=1) deleteFirst();
        Node secondLast = get(size-2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        System.out.println(val);
    }
    public void display(){
        if ( head == null ) System.out.println("List is Empty. ");
        Node temp = head;
        while (temp!= null )
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("End ");
    }
     void insertRec( int val , int index){
        head = insertRec(val,index,head);
     }
     private Node insertRec ( int val,int index, Node node ){
        if ( index == 0){
            Node currenode = new Node(val,node);
            size++;
            return currenode;
        }
        node.next=insertRec(val,index-1,node.next);
        return node;
     }
    public static void main(String[] args) {
        ll2  l2 = new ll2();
        l2.insertFirst(23);
        l2.insertFirst(32);
//        l2.insertFirst(3);
//        l2.insertFirst(2);
        l2.display();
        System.out.println("Insert Last lined list ");
        l2.insertLast(56);
        l2.insertLast(6);
        l2.insertLast(7);
//        l2.insertLast(8);
//        l2.insertLast(10);
//        l2.insert(100,4);
//        l2.display();
//        l2.deleteFirst();
//        l2.display();
//        l2.deleteLast();
        l2.display();
        l2.insertRec(32,3);
        l2.display();
//        System.out.println(l2.size);
    }
}

