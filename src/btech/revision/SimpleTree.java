package JAVA.revision;

import java.util.Scanner;

import static java.lang.System.in;

public class SimpleTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int value){
            this.data=value;
        }
    }
    static Node root;
    static void insert(Scanner scanner){
        System.out.print("Enter the root node -> ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    static private void insert(Node node,Scanner scanner){


        System.out.println("Do u want to add left of  "+node.data+" ? ->");
        boolean left = scanner.nextBoolean();

        if (left){
            System.out.println(" Left of "+node.data+" -> ");
            int leftValue = scanner.nextInt();
            node.left=new Node(leftValue);
            insert(node.left,scanner);
        }

        System.out.println("Do u want to add right of  "+node.data+" ? ->");
        boolean right = scanner.nextBoolean();

        if (right){
            System.out.println(" Left of "+node.data+" -> ");
            int rightValue = scanner.nextInt();
            node.right=new Node(rightValue);
            insert(node.right,scanner);
        }
    }

    static void print(){
        print(root);
    }
    private static void print(Node node){
        if ( node ==null){
            return;
        }
        System.out.print("   |");
        System.out.println("--->"+node.right);
        print(node.right);
        System.out.println();
        System.out.println("   |");
        print(root.left);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        insert(sc);
        print();
    }
}
