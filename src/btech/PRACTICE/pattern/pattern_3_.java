package JAVA.PRACTICE.pattern;

import java.util.Scanner;

//Write a program to print following :
//   *
//   *   *
//   *   *   *
//   *   *   *   *
//   *   *   *   *   *
public class pattern_3_ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);// scanner from keyboard ~~
        System.out.println("Enter number : "); //Entering number of times~~
        int num = sc.nextInt();

        for(int i=1; i<=num; i++){
            System.out.println();
            for (int j =1;j<=i;j++){
                System.out.print("   ");
                System.out.print("*");
            }
            if (i==num) return;
        }
    }
}
