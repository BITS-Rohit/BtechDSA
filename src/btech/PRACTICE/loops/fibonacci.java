package JAVA.PRACTICE.loops;
//Write a program to print Fibonacci series of n terms where n is input by user :
//0 1 1 2 3 5 8 13 24 .....

import java.util.Scanner;

public class fibonacci {
     public static void main(String[] args){
         double pre=0d; double next = 1d;double res;
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter FIb number : ");
         int m = sc.nextInt();
//         System.out.println(0d);System.out.println(1d);
         for (int i=0;i<m; i++){
             res= pre+next;
             pre=next;
             next=res;
             System.out.println(res);
         }
     }
}
