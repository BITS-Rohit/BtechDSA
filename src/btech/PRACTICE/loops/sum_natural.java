package JAVA.PRACTICE.loops;
//Write a program to calculate the sum of first 10 natural number.

import java.util.Scanner;

public class sum_natural {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number limit  : ");
        int n = in.nextInt();
        int sum =0;
        for (int i=0;i<n+1; i++){
            sum = sum+i;
        }
        System.out.println(sum);
    }
}
