package JAVA.PRACTICE.Methods;
import java.util.Scanner;

//A prime number is a number that is evenly divisible only by itself and 1.
// For example, the number 5 is prime because it can be evenly divided only by 1 and 5.
// The number 6, however, is not prime because it can be divided evenly by 1, 2, 4, and 6.
//Write a method named isPrime, which takes an integer as an argument and returns true
// if the argument is a prime number, or false otherwise.
// Also write Framework method that displays prime numbers between 1 and 500.
public class PRIME_NUMBER {
    static boolean prime(int n){
        if (n%2==0||n%3==0) return false;
        else if (n%5==0) return false;
        for (int i=5;i*i<n; i++){
            if (n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int c;
        do{
            System.out.println("Enter num : ");
            int  num=sc.nextInt();
            System.out.println("prime ? : "+prime(num));
            System.out.println("Enter 1 for Continue otherwise any number : ");
            c=sc.nextInt();
        } while (c!=1);
    }
}