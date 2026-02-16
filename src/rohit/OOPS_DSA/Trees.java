package rohit.OOPS_DSA;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Trees {
    static class Node {
        int value;
        private Node left;
        private Node right;

        Node(int data) {
            this.value = data;
        }
    }

    private Node root;

    void BinaryTree() {
        Scanner input = new Scanner(in);
        out.print("Root node - ");
        while (!input.hasNextInt()) {
            out.println("Acceptable Input of Type Integer/Number");
            out.print("Root node - ");
            input.next();
        }
        root = new Node(input.nextInt());
        Tree(root, input);
        out.println();
    }

    private void Tree(Node node, Scanner input) {
        left(node, input);
        right(node, input);
    }

    private void left(Node node, Scanner input) {
        out.print("Is root " + node.value + " has left node? ");
        String isLeft = input.next();
        if (isLeft.equalsIgnoreCase("yes")) {
            out.print("Value of left node - ");
            while (!input.hasNextInt()) {
                out.println("Invalid input. Please enter an integer.");
                out.print("Value of left node - ");
                input.next();
            }
            node.left = new Node(input.nextInt());
            out.println("   Success");
            Tree(node.left, input);
        } else if (isLeft.equalsIgnoreCase("no")) {
            out.println("OK. No node entry at left of " + node.value);
        } else {
            out.println("----Try again (Acceptable output yes/no----) ");
            left(node, input);
        }
    }

    private void right(Node node, Scanner input) {
        out.print("Is root " + node.value + " has right node? ");
        String isRight = input.next();
        if (isRight.equalsIgnoreCase("yes")) {
            out.print("Value of right node - ");
            while (!input.hasNextInt()) {
                out.println("Invalid input. Please enter an integer.");
                out.print("Value of right node - ");
                input.next();
            }
            node.right = new Node(input.nextInt());
            out.println("    Success");
            Tree(node.right, input);
        } else if (isRight.equalsIgnoreCase("no")) {
            out.println("OK. No node entry at right of " + node.value);
        } else {
            out.println("----Try again (Acceptable output yes/no----) ");
            right(node, input);
        }
    }

    void Display() {
        display(root, 0, "Root: ");
    }

    private void display(Node node, int level, String prefix) {
        if (node == null) {
            return;
        }

        String indent = " ".repeat(level * 4);
        out.println(indent + prefix + node.value);

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                display(node.left, level + 1, "L--> ");
            } else {
                out.println(indent + "    L--> null");
            }

            if (node.right != null) {
                display(node.right, level + 1, "R--> ");
            } else {
                out.println(indent + "    R--> null");
            }
        }
    }
    void display(){
        display(root, " ");
    }
    private void display(Node node,String  indent){
        if (node==null){
            return;
        }
        out.println(indent+node.value);
        display(node.left,indent+ " |--->");
        display(node.right,indent+" |--->");
    }
}
class BinarySearchTree{
    static class Node{
        int data ;
        Node left ;
        Node right;
        Node(int value){
            this.data= value;
        }
    }
    private Node root;

    void create(){
        Scanner input = new Scanner(in);
        out.print("Root node - ");
        if (!input.hasNextInt()){
            out.println(" Try Again. Give Integer/number value only ");
            input.nextInt();
        }
        root=new Node(input.nextInt());
        create(root,input);
    }

    private void create(Node node, Scanner input) {
        String choice;
        out.print("New Node enter ? (No for exit) - ");
        choice = input.next();
        if (choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("No")){
            if (choice.equalsIgnoreCase("yes")) {
                out.print("New Node entry : ");
                while (!input.hasNextInt()) {
                    out.println(" Try Again. Give Integer/number value only ");
                    input.next(); // Clear the invalid input
                    out.print("New Node entry : ");
                }
                int num = input.nextInt();
                if (num < node.data) {
                    if (node.left == null) {
                        node.left = new Node(num);
                        out.println("Success");
                        create(node.left, input);
                    } else {
                        create(node.left, input);
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(num);
                        out.println("Success");
                        create(node.right, input);
                    } else {
                        create(node.right, input);
                    }
                }
            }
            else if (choice.equalsIgnoreCase("no")){
                out.println("   ---Exited--   ");
            }
        }
        else {
            out.println("try again ");
            create(node,input);
        }

    }
    void display(){
        display(root," ");
    }
    private void display(Node node , String indent){
        if (node==null){
            return;
        }
        out.println(indent+node.data);
        display(node.left,indent+"L-->");
        display(node.right,indent+"R-->");
    }
}
