package JAVA.DSA;

import java.util.Scanner;

import static java.lang.System.in;

public class TREES {
    private static class Node {
        String value;
        Node left;
        Node right;
        Node(String value) {
             this.value = value;
         }
    }
    private  Node root;
    public void populate (Scanner scanner){
        System.out.println("Enter the root node : ");
        String value = scanner.next();
        root = new Node(value);
        populate(scanner,root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("do u want to enter the left of "+ node.value +" : " );
        boolean left = scanner.nextBoolean();
        if ( left ){
            System.out.println(" Enter the Left value of "+node.value+" : ");
            String left_val = scanner.next();
            node.left = new Node(left_val);
            populate(scanner, node.left);
        }
        System.out.println("Do u want to enter the right value of "+node.value+ " : ");
        boolean right = scanner.nextBoolean();
        if ( right){
            System.out.println(" Enter the right node value of "+ node.value+ " : ");
            String right_val = scanner.next();
            node.right = new Node(right_val);
            populate(scanner,node.right);
        }
    }
    void display(){display(this.root," ");}
    private void display(Node node, String indent){
        if ( node ==  null ){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left,indent+ "\t");
        display(node.right,indent);
    }
    void Display(){
        Display(this.root,0);
    }
    private void Display(Node node , int level){
        if ( node == null) return;

        Display(node.right,level+1);
        if ( level != 0){
            for (int i = 0; i <level-1 ; i++) {
                System.out.print("| \t \t");
            }
            System.out.println(" |----------->  "+node.value );
        }else System.out.println(node.value);
        Display(node.left,level+1);
    }


    public static void main(String[] args) {
    Scanner sc = new Scanner(in);
    TREES t = new TREES();
    t.populate(sc);
    t.Display();
//    Stack<Integer> s = new Stack<>();
    }
}
