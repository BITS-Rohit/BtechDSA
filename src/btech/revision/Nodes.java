package JAVA.revision;

public class Nodes {
    static class Node{
        int data;
        Node next;
        Node(int value){
            this.data = value;
            this.next=null;
        }
    }
    static Node head;
    static int size=1;
//    static Node tail;
    static void start(int value ){
        Node newnode = new Node(value);
        if (head == null ){
            head = newnode;
            size++;
            return;
        }
        newnode.next=head;
        head = newnode;
        size++;
    }
    static void insert(int value, int pos){
        if (head==null){
            start(value);
            return;
        }
        if (pos==1){
            start(value);
            return;
        }
        Node tempnode = head;
        int tempSize=1;
        while(tempnode!=null && size<pos){
            if (tempSize+1==pos){
                Node newnode = new Node(value);
                tempnode.next=newnode;
                newnode.next=tempnode.next.next;
                break;
            }
            tempnode=tempnode.next;
            tempSize++;
        }
    }
    static void display(){
        Node Display = head;
        while(Display!=null){
            System.out.print(Display.data+" --> ");
            Display=Display.next;
        }
        System.out.println(" End ");
    }

    static void RevDisplay(){
        rev(head);
        System.out.println("start");
    }

    private static void rev(Node node) {
        if ( node == null){
            return;
        }
        rev(node.next);
        System.out.print(node.data+"<---");
    }
    static void delete(int data){
        if (head == null){
            System.out.println("Empty ");
            return;
        }
        int size=1;
        Node current = head;
        while (current.next!=null){
            if (data == current.data && size==1){
                head = head.next;
                break;
            }
            if (current.next.data==data){
                current.next =current.next.next;
                return;
            }
            current=current.next;
            size++;
        }
        System.out.println("Element Not Found");
    }

    static void MultiPOS(int pos){
        if (head==null){
            System.out.println("Empty");
            return ;
        }
        if (pos==0){
            System.out.println("Invalid position");
        }
        if (pos==1){
            System.out.println("Multiplication upto "+pos+" is : "+head.data);
            return ;
        }
        int size=1;
        int Mul=1;
        Node current = head;
        while(current.next!=null && size<pos){
            Mul*=current.data;
            if (size+1==pos ){
                Mul=Mul * current.next.data;
                System.out.println("Multiplication upto "+pos+" is : "+Mul);
            }
            size++;
            current=current.next;
        }
        if (size<pos){
            System.out.println("Position is out of range");
        }
    }

    static void AddPos(int pos){
        if (head == null){
            System.out.println("Empty");
            return;
        }
        if (pos==0){
            System.out.println("invalid Position ");
            return;
        }
        if ( pos ==1){
            System.out.println("Addition upto "+pos+" is : "+head.data);
            return;
        }
        int size=1;
        int Sum=0;
        Node current = head;
        while(current.next!=null && size<pos){
            Sum+=current.data;
            if (size+1==pos){
                Sum=Sum +current.next.data;
                System.out.println("Addition upto "+pos+" is : "+Sum);
            }
            size++;
            current=current.next;
        }
        if (size<pos){
            System.out.println("Position is out of range");
        }
    }

    public static void main(String[] args) {
        start(30);
        start(20);
        start(10);
        insert(40,4);
//        display();
//        insert(40,3);
//        display();
//        RevDisplay();
//        delete(30);
//        System.out.println("removed ");
        display();
        MultiPOS(5);
        AddPos(3);
    }
}
