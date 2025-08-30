package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program that prompts the user to input an integer and then outputs the number with the digits reversed.
// For example, if the input is 12345, the output should be 54321.
public class reverse_num {
   /* public static int rev(int n){
        if (n ==0) return 0;

        else return rev(n%10)+n+n/10;
    }*/
    public static void main(String[] args){
        Scanner  in = new Scanner(System.in);
        System.out.println("Enter digits : ");
        int n = in.nextInt();
        do {
            int result = n%10;
            System.out.printf("%d" ,result);
            n = n/10;

        }while (n>0);
    }
}
