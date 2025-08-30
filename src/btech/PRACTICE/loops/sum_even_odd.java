package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
// The loop should ask the user whether he or she wishes to perform the operation again.
// If so, the loop should repeat; otherwise, it should terminate.
public class sum_even_odd {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int even = 0;int odd = 0;int choice;
        do {
            System.out.println("Enter number : ");
            int Integer= sc.nextInt();
            if (Integer%2==0)  even+=Integer;
            else odd+=Integer;
            System.out.println("Press 1 for EXIT or Any for continue : ");
            choice =sc.nextInt();
        }while (choice!=1);
        System.out.println("SUM of even integers : "+even);
        System.out.println("SUM of odd integers : "+odd);
    }
}
