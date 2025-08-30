package JAVA.PRACTICE.Methods;

import java.util.Scanner;

//A non-negative integer is called a palindrome if it reads forward and backward in the same way.
// For example, the numbers 5, 121, 3443, and 123454321 are palindromes.
// Write a method that takes as input a non-negative integer and returns true if the number is a palindrome;
// otherwise, it returns false.
// Also write a program to test your method.
public class palindrome_function {
    public static boolean palindrome(int n){
        int temp=n;
        int r;int sum = 0;
        while (temp>0){
            r = temp%10;
            temp=temp/10;
            sum=(sum*10)+r;
        }
        return sum==n;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num : ");
        int num = sc.nextInt();
        if (palindrome(num)) System.out.println("Its palindrome ");
        else System.out.println("No its not a palindrome ");
    }
}