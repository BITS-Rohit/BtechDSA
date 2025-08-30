package JAVA.PRACTICE.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class reverse_1D  {
    static void reverse(int[] array ,int size){
        int[]b =new int[size];
        int j = size;
        for (int i=0;i<size; i++){
            b[j-1]=array[i];
            j--;
        }
        System.out.println(Arrays.toString(b));
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int size = sc.nextInt();
        int[] ar=new int[size];
        for (int i=0;  i<size;  i++)
        {
            System.out.println("Enter "+i+"element :");
            ar[i]= sc.nextInt();
        }
        System.out.println("After Reversing : ");
        System.out.println(Arrays.toString(ar));
        reverse(ar,size);
    }
}
