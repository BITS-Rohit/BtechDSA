package JAVA.PRACTICE.Methods;

import java.util.Scanner;

//Write a value-returning method, isVowel that returns the value true if a given character is a vowel,
// and otherwise returns false.
// In Framework() method accept a string from user and count number of vowels in that string.
public class is_Vowel {
    static boolean isVowel(char st){
        return switch (st) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any line :");
        String s = sc.next();
        int count = 0;
        for (int i=0;i<s.length(); i++){
            if (isVowel(s.charAt(i))) count ++;
        }
        System.out.println("Counts : "+count);
    }
}
