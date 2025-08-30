package JAVA.PRACTICE.loops;

import java.util.Arrays;
import java.util.Scanner;

//The variable list1 and list2 are reference arrays that each have 5 elements.
// Write code that copies the values in list1 to list2.
// Values in list1 are input by the user.
public class list_array_add {
    static int[] add(int[] list1, int[] list2){
        int i;
        int[] new_arr= new int[list1.length + list2.length];

        for (i = 0; i< list1.length+1; i++)
        {
            new_arr[i]=list1[i];
        }
        for (i = 0; i< list2.length+1; i++)
        {
            new_arr[i]=list2[i];
        }
        return new_arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st list size: ");
        int[] list1 = new  int[sc.nextInt()];

        System.out.println("Enter 2nd list size: ");
        int[] list2 = new  int[sc.nextInt()];

        for (int i=1;i<=list1.length ; i++){
            System.out.println("Enter 1st list's "+i+" element :");
            list1[i]= sc.nextInt();
        }
        for (int i=1;i<=list2.length ; i++){
            System.out.println("Enter 2nd list's "+i+" element :");
            list2[i]= sc.nextInt();
        }
        System.out.println("New array with 2 list append : ");
        System.out.println(Arrays.toString(add(list1, list2)));
    }
}
