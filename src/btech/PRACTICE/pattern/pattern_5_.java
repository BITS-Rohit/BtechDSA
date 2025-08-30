package JAVA.PRACTICE.pattern;

import java.util.Scanner;

//Write a program to print following :
//       *        ~~1
//      ***       ~~3
//     *****      ~~5
//    *******     ~~7
//   *********    ~~9
public class pattern_5_ {
    public static void main(String[] args){
        int j;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ur number : ");
        int  row = sc.nextInt();
        for(int i=0; i< row; i++){

            for ( j=row-i; j>0; j--)
            {
                System.out.print(" ");
            }
            for ( j =0;j<=i;j++)
            {
                System.out.print("* ");
                //System.out.print("❣ ");
            }
            System.out.println();
        }
        System.out.println();
        //System.out.println("❣I LOVE YOU.....LOVE YOU ----->>>LOVE YOU❣");
    }
}
