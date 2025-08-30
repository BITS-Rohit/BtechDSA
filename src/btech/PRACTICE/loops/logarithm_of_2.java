package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Compute the natural logarithm of 2, by adding up to n terms in the series
//1 - 1/2 + 1/3 - 1/4 + 1/5 -... 1/n
//where n is a positive integer and input by user.
public class logarithm_of_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int sign=1;
        double sum=0d;

        System.out.println("Enter Nth term : ");
        int nth = sc.nextInt();

        for(int i=1; i<=nth; i++){
            sum += (1.0 *sign)/i;
            sign*=-1;
        }
        System.out.println("Log2 : "+sum);
    }
}
