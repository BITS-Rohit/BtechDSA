package btech.java_MTE.src;

import java.util.Arrays;
import java.util.Scanner;

public class insert_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size+1];
        System.out.print("Enter "+size+" elements: ");
        for (int i =0; i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before insertion: "+ Arrays.toString(arr));

        System.out.print("Enter the element to be inserted: ");
        int num = sc.nextInt();
        System.out.print("Enter the position: ");
        int pos = sc.nextInt();
        for (int i = size; i>pos;i--){
            arr[i] = arr[i-1];
        }
        arr[pos] = num;
        size++;
        System.out.println("Array after insertion: ");
        for (int i =0; i<size;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
