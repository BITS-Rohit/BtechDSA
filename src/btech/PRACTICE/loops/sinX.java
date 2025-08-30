package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a program to compute sin X for given x. The user should supply x and a positive integer n. We compute the sine of x using the series and the computation should use all terms in the series up through the term involving xn
//
//sin x = x - x3/3! + x5/5! - x7/7! + x9/9! .......
public class sinX {
    static int fac(int n){
        if ( n==1||n==0) return n;
        else  return n*fac(n-1);
    }
    public static int pow(int base , int power){
        if (base == 0 ) return 0;
        else if (base ==1) return 1;
        else if (power ==0||power ==1) return base;
        else return base * pow(base,power -1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sign =1;
        int result = 0;int series;
        System.out.println("Enter x value for computing sin X : ");
        int value = sc.nextInt();
        for (int i=1;i<= value; i++)
        {
            series = (pow(value,i)/fac(i))*sign;
            result+=series;
            sign*=-1;
        }
        System.out.println("sin X : "+result);
    }
}