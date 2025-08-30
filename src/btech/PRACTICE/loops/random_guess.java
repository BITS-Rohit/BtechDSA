package JAVA.PRACTICE.loops;
//Write a program that generates a random number and asks the user to guess what the number is.
// If the user's guess is higher than the random number, the program should display "Too high, try again."
// If the user's guess is lower than the random number, the program should display "Too low, try again."
// The program should use a loop that repeats until the user correctly guesses the random number.

import java.util.Random;
import java.util.Scanner;

public class random_guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rc = new Random();
        int rand = rc.nextInt(5);
        int num;
        System.out.println("Guess a number between 0 to 5 :");
        do {
            System.out.println("Guess :");
            num = sc.nextInt();
            if (rand == num) System.out.println("Correct !!!!");
            else if (rand > num) System.out.println("Too low try again");
            else System.out.println("Too high try again");
        } while (rand!= num);
    }
}
