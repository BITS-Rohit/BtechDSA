package JAVA.PRACTICE.loops;
//Write a program that prompts the user to input a positive integer. It should then print the multiplication table of that number.

import java.util.Scanner;

public class table_multiply {
    public static void multiply(int n ){
        for (int i=1;i<11; i++){
            System.out.println(n+" x "+i+" = "+n*i);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number : ");
        int n = in.nextInt();
        multiply(n);
    }
}
