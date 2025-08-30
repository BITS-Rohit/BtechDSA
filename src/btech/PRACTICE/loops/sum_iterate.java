package JAVA.PRACTICE.loops;

import java.util.Scanner;

//Write a do-while loop that asks the user to enter two numbers. The numbers should be added and the sum displayed. \
// The loop should ask the user whether he or she wishes to perform the operation again. If so, the loop should repeat
// otherwise it should terminate.
public class sum_iterate {
    static int sum =0;
    public static int sum_num(int n1, int n2){

        sum = n1+n2;
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1,n2,select;
        do {
            System.out.println("Enter 1st num : ");//number 1st enter
            n1 = sc.nextInt();
            System.out.println("Enter 2nd num : ");//number 2nd enter
            n2 = sc.nextInt();
            System.out.println("Sum is : " + sum_num(n1,n2));
            System.out.println("Enter [1] for continue or any other to exit : ");//initialisation of select
            select =sc.nextInt(); //keyboard input
        } while (select ==1); //loop until users wants  !!!!!
    }
}
