package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
public class sumofdigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Integer  : ");
        int n = sc.nextInt();
        int[] num= new int[n];
        int sum_even=0;
        int sum_odd=0;
        //assuming that the given number is positive and greater than 0
        for (int i=0;i<n; i++){
            System.out.println("Enter numbers : ");
             num= new int[]{sc.nextInt()};
        }
        for (int j : num){
            if (j%2==0) sum_even = sum_even+j;
            else sum_odd = sum_odd+j;
        }
        System.out.println("Sum of even: "+sum_even);
        System.out.println("Sum of odd: "+ sum_odd);
    }
}