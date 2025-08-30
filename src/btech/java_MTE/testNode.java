package btech.java_MTE;

import java.util.Scanner;

public class testNode {
    static class Node{
        int data;
        static Node left;
        static Node right;
        Node(int value){
            this.data = value;
            left = null;
            right= null;
        }
    }
    static Node root;
    static void create(){
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the root node : ");
        root = new Node(sc.nextInt());
        insert(root,sc);
    }
    private static void insert(Node node, Scanner sc){
        if (String.valueOf(node.data).equals(" ")){
            return;
        }
        System.out.print("left of "+node.data+" is : ");
        int leftValue = sc.nextInt();
        if (!String.valueOf(leftValue).equals(" ")){
            Node.left = new Node(leftValue);
            insert(Node.left,sc);
        }
        System.out.print("right of "+node.data+" is : ");
        int rightValue = sc.nextInt();
        if (!String.valueOf(rightValue).equals(" ")){
            Node.right = new Node(rightValue);
            insert(Node.right,sc);
        }
    }
    public static void main(String[] args){
        create();
    }
}
