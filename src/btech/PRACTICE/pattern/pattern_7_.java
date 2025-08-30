package JAVA.PRACTICE.pattern;

import java.util.Scanner;

//Write a program to print following :
//        1
//       212
//      32123
//     4321234
//    543212345
public class pattern_7_ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nth size number : ");
        int row = sc.nextInt();
        for (int i=1;i<=row; i++)
        {
            for (int j = row-i; j>0; j--)  System.out.print(" ");

            for (int j =i;j>=1;j--)  System.out.print(j);

            for (int j =2;j<=i;j++)  System.out.print(j);

            System.out.println();
        }
    }
}
