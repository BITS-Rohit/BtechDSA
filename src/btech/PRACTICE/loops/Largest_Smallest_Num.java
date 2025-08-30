package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program to enter the numbers till the user wants
// And at the end the program should display the largest and smallest numbers entered.
public class Largest_Smallest_Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min =0;int max =0;
        int n1;int n2=0;
        char choice;
        do {
            System.out.println("Enter 1st number : "); n1=sc.nextInt();
            System.out.println("Enter 2nd number : "); n2-=sc.nextInt();
            if (n1>n2) max =n1;
            if(n2>n1) min =n2;
            System.out.println("Largest : "+ max);
            System.out.println("Smallest : "+min);
            System.out.println(" press E for EXIT or any to continue : ");
            choice = sc.next().charAt(0);
        }while (choice!='E');
    }
}
