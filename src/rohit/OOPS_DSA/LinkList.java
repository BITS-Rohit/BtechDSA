package rohit.OOPS_DSA;

class LinkList {
    private static  int size = 0; // Correctly track the size of the list

    static class Node {
        private int data;
        private Node next;

        private Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    private Node head;

    int getSize() {
        return size;
    }

    boolean isNull() {
        return head == null;
    }

    void insert(int value, int position) {
        Node newNode = new Node(value);
            if (isNull() || position==1){
                newNode.next=head;
                head=newNode;
            }
            else {
                Node current = head;
                int temp=1;
                while (temp<position-1 && current.next!=null ){
                    current=current.next;
                    temp++;
                }
                newNode.next=current.next;
                current.next=newNode;
            }
            size++;
        if (position <= 0 || position>size) {
            System.out.println("Invalid position (" +position+ ") entered ...\nCurrent size: " + getSize());
        }
    }


    int getData(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position entered ...\nCurrent size: " + getSize());
            return Integer.MIN_VALUE;
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.data;
    }

    void setData(int value, int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position entered ...\nCurrent size: " + getSize());
            return;
        }

        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        current.data = value;
    }

    int remove(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position entered ...\nCurrent size: " + getSize());
            return Integer.MIN_VALUE;
        }

        int data;
        if (pos == 0) { // Remove head node
            data = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            data = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return data;
    }

    int getValue(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position entered ...\nCurrent size: " + getSize());
            return Integer.MIN_VALUE;
        }

        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    void display() {
        Node current = head;
        System.out.print("Start -> ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("End");
    }
}

//
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//

class DoublyLinkedList{

    private int size=0;

    static class Node{
        private int data;
        private Node next;
        private Node prev;
        private Node(int value){
            data= value;
            next=null;
            prev=null;
        }
    }
    private Node head;
    private Node tail;

    boolean isnull(){
        return head==null;
    }
    int getSize(){
        return size;
    }
    void insert(int value){
        Node newnode = new Node(value);
        if (isnull()){
            head = newnode;
            tail =newnode;
            size++;
            return;
        }
        newnode.next = head;
        head.prev=newnode;
        head= newnode;
        size++;
    }
    void insert(int value , int pos){
        Node newnode = new Node(value);
        if (isnull() ) {
            insert(value);
        }
        if (pos<=size && pos>0 ){
            if (pos==1){
                newnode.next=head;
                head.prev=newnode;
                head=newnode;
                size++;
                return;
            }
            if (pos==size && !isnull()){
                tail.next=newnode;
                newnode.prev=tail;
                tail=newnode;
                size++;
                return;
            }
            Node current =head;
            int temp=0;
            while(temp<pos-1){
                current=current.next;
                temp++;
            }
            newnode.next=current.next;
            newnode.prev=current;
            current.next.prev=newnode;
            current.next=newnode;
            size++;
        }
        else System.out.println("Invalid position ! \n Current size is : "+size);
    }
    void display(){
        Node current = head;
        System.out.print("||  Start ~~> ");
        while (current!=null){
            System.out.print(current.data +" ~~> ");
            current=current.next;
        }
        System.out.println("End  ||");
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class CircularLinkedList {
    static class Node {
        Node next;
        int data;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    boolean isNull() {
        return head == null;
    }

    void insert(int value, int index) {
        Node newNode = new Node(value);

        if (index < 1 || index > size + 1) {
            System.out.println("Invalid position " + index + ". Current size: " + size);
            return;
        }

        if (index == 1) {
            if (isNull()) {
                head = newNode;
                tail = newNode;
                tail.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
            size++;
            System.out.println("New Entry Done!");
            return;
        }

        if (index == size + 1) {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
            size++;
            System.out.println("New Entry Done!");
            return;
        }

        int temp = 1;
        Node current = head;
        while (temp < index - 1) {
            current = current.next;
            temp++;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("New Entry Done!");
    }


    void prettyDisplay() {
        if (isNull()) {
            System.out.println("No entry in Nodes caught.");
            return;
        }

        Node current = head;
        System.out.print("Start -> ");
        int temp = 1;
        while (temp <= size / 2) {
            System.out.print(current.data + " -> ");
            current = current.next;
            temp++;
        }
        System.out.println();

        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print("\t");
        }
        System.out.println("|");

        System.out.print("^-- ");
        // Collect the second half values in reverse order
        Node[] reverseHalf = new Node[size - size / 2];
        temp = 0;
        while (temp < reverseHalf.length) {
            reverseHalf[temp] = current;
            current = current.next;
            temp++;
        }
        for (int i = reverseHalf.length - 1; i >= 0; i--) {
            System.out.print(reverseHalf[i].data + " <- ");
        }
        System.out.println("Start");
    }


    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        System.out.println("Is Node entry empty? " + c.isNull());
        c.insert(10, 1);
        c.insert(20, 2);
        c.insert(30, 3);
        c.insert(40, 4);
        c.insert(50, 5);
        c.insert(60, 6);
        c.insert(70, 7);
        c.insert(80, 8);
        c.prettyDisplay();

    }
}

