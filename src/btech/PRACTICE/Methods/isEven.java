package JAVA.PRACTICE.Methods;

import java.util.Scanner;

//Write a method named isEven that accepts an int argument.
// The method should return true if the argument is even, or false otherwise.
// Also write a program to test your method.
public class isEven {
    static boolean is_even(int n ){
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ur number : ");
        int num=sc.nextInt();
        System.out.println("SYSTEM ? : \nAnswer : "+is_even(num));
    }
}
