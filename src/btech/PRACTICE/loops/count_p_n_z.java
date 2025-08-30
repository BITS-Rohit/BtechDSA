package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program to enter the numbers till the user wants and at the end
// It should display the count of positive, negative and zeros entered.
public class count_p_n_z {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c_p = 0, c_n=0,c_z=0;
        int choice;
        do {
            System.out.println("Enter integer : ");
            int in = sc.nextInt();
            if (in > 0)  c_p++;
            else if (in < 0) c_n++;
            else  c_z++;
            System.out.println(" press 1 for EXIT or any to continue : ");
            choice = sc.nextInt();

        } while (choice!=1);
        System.out.println("Count of positive num is : "+c_p);
        System.out.println("Count of negative num is :"+c_n);
        System.out.println("Count of zero num is :"+c_z);

    }
}
