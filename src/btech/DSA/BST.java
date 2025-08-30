package Btech.DSA;

import java.util.Scanner;

import static java.lang.System.in;

public class BST {
    private static class Node{
        private Node left;
        private Node right;
        private  int value;
        private int height;

        Node (int val){
            this.value = val;
        }

        int getValue(){
            return value;
        }
    }
    private Node root;
    void create (){
        Scanner sc = new Scanner(in);
        create(sc);
    }
    void create(Scanner sc){
        System.out.print("Enter the root node : ");
        int value = sc.nextInt();
        root = new Node(value);
        create(sc,root);
    }
    void create(Scanner sc,Node node) {
        System.out.println(" Want to Enter on left node of "+node.value+" : ");
        boolean left = sc.nextBoolean();
        if ( left )
        {
            System.out.println("Enter the value for left of "+ node.value+" : ");
            int left_val = sc.nextInt();
            node.left= new Node(left_val);
            create(sc,node.left);
        }

        System.out.println(" Want to Enter on right node of "+node.value+" : ");
        boolean right = sc.nextBoolean();
        if ( right )
        {
            System.out.println("Enter the value for right of "+ node.value+" : ");
            int right_val = sc.nextInt();
            node.right= new Node(right_val);
            create(sc,node.right);
        }

    }
     boolean isnull(Node node){
        return node==null;
     }

    int getHeight(Node node){
        if (node == null) return -1;
        return node.height;
    }
     boolean isEmpty(){ return root==null;}
     void display(){
        display(root," Root node ");
     }
     void display( Node node,String details){
        if ( node==null){
            return ;
        }
        System.out.println(details + node.getValue());
        display(node.left,"left child of "+node.getValue()+ " : ");
        display(node.right,"right child of "+node.getValue()+ " : ");
     }

     void insert(int val){
        root = insert(val,root);
     }
     Node insert(int value , Node node ){
        if ( value <node.value) node.left= insert(value,node.left);
        if (value>node.value) node.right = insert(value, node.right);
        node.height = Math.max(getHeight(node.left),getHeight(node.right)+1);
        if (isnull(node)){
            node = new Node(value);
            return node;
        }
        return node;
     }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.create();
        bst.display();
    }
}
