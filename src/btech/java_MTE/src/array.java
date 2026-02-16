package btech.java_MTE.src;

import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] arr1= new int[2][2];

            // Take the array size from the user
        System.out.println("Enter the size of the  1D array: ");
        int arr_size = 0;
        if (sc.hasNextInt()) {arr_size = sc.nextInt();}

            // Initialize the array's
            // size using user input
        int[] arr = new int[arr_size];

            // Take user elements for the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr_size; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }
        System.out.println("The elements of the array are: ");
        for (int i : arr) {
            // prints the elements of an array
            System.out.print(i+ " ");
        }
        System.out.println("1D Array : " + Arrays.toString(arr));

        System.out.println("Enter element for 2d array: ");
        for (int i=0;i<arr1.length; i++){
            for (int j = 0; j<arr1.length; j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter element for 2D array: "+ Arrays.toString(arr1));
        for ( int[] a:arr1){
            for(int b : a){
                System.out.println(b+ " ");
            }
        }
        sc.close();
    }
}
