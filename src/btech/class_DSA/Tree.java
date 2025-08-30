package Btech.class_DSA;

import java.util.Scanner;

import static java.lang.System.in;

class Tree {
    static class Node{
        int data;
        Node next;
        Node(int value){
            this.data=value;
            this.next = null;
        }
    }
    static Node root;
    static Node left;
    static Node right;
    static void insert(int value ){
        Scanner sc = new Scanner(in);
        if (root ==null){
            root = new Node(value);
        }
        System.out.println("Wanna store the  left of "+root.data+ " ? --> ");
        boolean leftBool = sc.hasNextBoolean();
        if (leftBool) {
            System.out.println("Enter the left value of the "+root.data+" : ");
            int leftValue = sc.nextInt();
            left =new Node(leftValue);
        }


        System.out.println("Wanna store the right of "+root.data+" ? --> ");
        boolean rightBool = sc.hasNextBoolean();
        if (rightBool) {
            System.out.println("Enter the right value of the "+root.data+" : ");
            int rightValue = sc.nextInt();
            right=new Node(rightValue);

        }
    }

    public static void main(String[] args) {
        insert(8);
    }
}
