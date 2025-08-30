package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program to calculate the sum of following series where n is input by user.
//1 + 1/2 + 1/3 + 1/4 + 1/5 +…………1/n
public class sum_of_series {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c;double sum=0d;
        do {
            System.out.println("Enter nth times : ");
            int s_num = sc.nextInt();
            for (int i=1;i<= s_num; i++){
                sum+=1.0/i;
                System.out.print(sum+ "--->");
            }
            System.out.println("Press 1 for exit : ");
            c=sc.nextInt();
        }while (c!=1);
    }
}
