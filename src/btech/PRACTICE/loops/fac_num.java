package JAVA.PRACTICE.loops;
//Write a program to find the factorial value of any number entered through the keyboard.

import java.util.Scanner;

public class fac_num {
    public static int fac(int n){
        if (n ==0||n==1){
            return 1;
        }
        else return n * fac(n-1);
    }
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter fac no : ");
        int n = in.nextInt();
        System.out.println("Factorial :"+ fac(n));
    }
}
