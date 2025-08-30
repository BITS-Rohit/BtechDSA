package JAVA.PRACTICE.loops;
//Write a program to print numbers from 1 to 10.
import java.util.Scanner;

public class print_num {

    public static int p_num(int n, int max){
        System.out.println(n);
        if ( n==max){return -1;}
        else {return  p_num(n+1,max);}
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Starting num : ");
        int n = sc.nextInt();
        System.out.println("Enter Ending num : ");
        int max = sc.nextInt();
        System.out.println(p_num(n,max));     //printing using recursion

    }
}

