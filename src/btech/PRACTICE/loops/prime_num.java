package JAVA.PRACTICE.loops;

import java.util.Scanner;

public class prime_num {
    public static boolean isPrime(int n ){
        if (n%2==0||n%3==0) return false;
        if (n == 1) return  true;
        for (int i=5;i*i<n; i++){if (n%i ==0) return false;}
         return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter any POSITIVE Integer : "); int n = sc.nextInt();
        System.out.println("IS THIS PRIME : "+isPrime(n));
    }
}
