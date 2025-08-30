package JAVA.PRACTICE.loops;
//Two numbers are entered through the keyboard.
// Write a program to find the value of one number raised to the power of another. (Do not use Java built-in method)

import java.util.Scanner;

public class power_num {
    public static int pow(int base , int power){
        if (base == 0 ) return 0;
        else if (base ==1) return 1;
        else if (power ==0||power ==1) return base;
        else return base * pow(base,power -1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base number : ");
        int base = in.nextInt();
        System.out.println("Enter power : ");
        int power = in.nextInt();
        System.out.println("Power is  : "+ pow(base,power));
    }
}
