package JAVA.PRACTICE.pattern;
//Write a program to print following :
//        *
//       **
//      ***
//     ****
//    *****

import java.util.Scanner;

public class pattern_4_{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num : ");

        int row = sc.nextInt();

        for (int i=0; i<row; i++)
        {
            for(int j=(row-i); j>0; j--)
            {
                System.out.print(" ");
            }
            for (int k =0;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
