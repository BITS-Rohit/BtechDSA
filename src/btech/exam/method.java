package JAVA.exam;

import java.util.Scanner;

class  adder {
    static int add(int a , int b){return a+b;}
    static  double add ( int a , int b, int c){return  a+b+c;}
}
public class method {
    public static void main(String[] args){

        Scanner sn = new Scanner(System.in);

        System.out.println("Enter n1 = ");
        int n1 = sn.nextInt();
        System.out.println("Enter n1 = ");
        int n2 = sn.nextInt();
        System.out.println("Enter n3 = ");
        int n3 = sn.nextInt();
        System.out.println(adder.add(n1,n2));
        System.out.println(adder.add(n1,n2, n3));

    }
}
