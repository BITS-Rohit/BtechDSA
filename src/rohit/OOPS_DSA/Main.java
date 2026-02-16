package rohit.OOPS_DSA;

public class Main {
//        LinkList list = new LinkList();
//        list.insert(1,1);
//        list.insert(2,1);
//        list.insert(3,1);
//        list.insert(4,1);
//        list.insert(5,1);
//        list.display();
//        System.out.println(list.getSize());
//
//        list.insert(10,6);
//
//        list.display();
//        System.out.println(list.getSize());
//        System.out.println(list.getData(1));
//        System.out.println(list.getData(0));
//        list.setData(100,list.getSize());
//        list.display();
//        System.out.println(list.remove(4));
//        list.display();
//        System.out.println(list.getSize());


//        DoublyLinkedList d = new DoublyLinkedList();
//        d.insert(1);
//        d.insert(2);
//        d.insert(3);
//        d.insert(4);
//        d.insert(100,4);
//        d.display();
//        System.out.println(d.getSize());


//        for (int i = 0; i < 4; i++) {
//            System.out.print(i+"->");
//        }
//        System.out.println();
//        for (int i = 0; i <= 2; i++) {
//            System.out.print("\t ");
//        }
//        System.out.print( "@" );

//    static class CircularLinkedList {
//        static class Node {
//            Node next;
//            int data;
//
//            Node(int value) {
//                this.data = value;
//                this.next = null;
//            }
//        }
//
//        private int size;
//        private Node head;
//        private Node tail;
//
//        boolean isNull() {
//            return head == null;
//        }
//
//        void insert(int value, int index) {
//            Node newNode = new Node(value);
//
//            if (index < 1 || index > size + 1) {
//                System.out.println("Invalid position " + index + ". Current size: " + size);
//                return;
//            }
//
//            if (index == 1) {
//                if (isNull()) {
//                    head = newNode;
//                    tail = newNode;
//                    tail.next = head;
//                } else {
//                    newNode.next = head;
//                    head = newNode;
//                    tail.next = head;
//                }
//                size++;
//                System.out.println("New Entry Done!");
//                return;
//            }
//
//            if (index == size + 1) {
//                if (isNull()) {
//                    head = newNode;
//                    tail = newNode;
//                    tail.next = head;
//                } else {
//                    tail.next = newNode;
//                    tail = newNode;
//                    tail.next = head;
//                }
//                size++;
//                System.out.println("New Entry Done!");
//                return;
//            }
//
//            int temp = 1;
//            Node current = head;
//            while (temp < index - 1) {
//                current = current.next;
//                temp++;
//            }
//            newNode.next = current.next;
//            current.next = newNode;
//            size++;
//            System.out.println("New Entry Done!");
//        }
//
//        void prettyDisplay() {
//            if (isNull()) {
//                System.out.println("No entry in Nodes caught.");
//                return;
//            }
//
//            Node current = head;
//            StringBuilder upperRow = new StringBuilder();
//            StringBuilder lowerRow = new StringBuilder();
//
//            do {
//                upperRow.append("[Data: ").append(current.data).append(", Next: ").append(current.next.data).append("] -> ");
//                lowerRow.insert(0, " <- [Data: " + current.data + ", Next: " + current.next.data + "]");
//                current = current.next;
//            } while (current != head);
//
//            System.out.println(upperRow);
//            System.out.println(lowerRow);
//        }
//    }
    public static void main(String[] args) {
//        CircularLinkedList cll = new CircularLinkedList();
//        cll.insert(10, 1);
//        cll.insert(20, 2);
//        cll.insert(30, 3);
//        cll.insert(40, 4);
//        cll.insert(50, 5);
//        cll.prettyDisplay();


//        Trees tree = new Trees();
//        tree.BinaryTree();
//        tree.Display();
//        System.out.println("\n \n");
//        tree.display();

//        BinarySearchTree bst = new BinarySearchTree();
//        bst.create();
//        bst.display();



//        StackGeneric<String> stack = new StackGeneric<>();
//
//        stack.push("1");
//        stack.push("2");
//        stack.push("3");
//        stack.push("4");
//        stack.push("End");
//        stack.display();
//        stack.pop();
//        stack.display();
//        Stack<Integer> s = new Stack<>();



//        QueueByArray q = new QueueByArray();
//        q.push(1);
//        q.push(2);
//        q.push(3);
//        q.push(4);
//        q.push(5);
//        System.out.println(q.getSize());
//        System.out.println(q.pop());
//        System.out.println(q.getSize());
//
//        Deque<Integer> d = new ArrayDeque<>();
//        Deque<Integer> d1= new LinkedList<>();

        AVL tree = new AVL();

        tree.start();
        System.out.println(tree.height());
//        tree.display();

        
    }
}
