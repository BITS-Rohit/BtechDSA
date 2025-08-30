package JAVA.PRACTICE.pattern;

import java.util.Scanner;

//Write a program to print following :
//
//        1
//       222
//      33333
//     4444444
//    555555555
public class pattern_6_ {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nth size number : ");
        int row = sc.nextInt();

        for (int i=1;i<=row; i++)
        {
            for (int j = (row-i); j>0 ; j--)
            {
                System.out.print(" ");
            }
            for (int j =1;j<=2*i-1;j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
        sc.close();
    }
}
