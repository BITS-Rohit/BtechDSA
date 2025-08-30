package JAVA.exam;

import java.util.Arrays;
import java.util.Scanner;

public class _1_calculator {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("1. Addition");
        System.out.println("2. Subtract");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.println();

        System.out.println("Enter your choice : ");
        int c = in.nextInt();
        System.out.println("Enter your 1st  input:");
        byte in1= in.nextByte();
        System.out.println("Enter your 2nd input: ");
        byte in2 = in.nextByte();

        int in3;

        switch (c){
            case 1 :
                in3= in1 + in2;
                System.out.println("Addition : "+in3);
                break;

            case 2 :
                in3= in1 - in2;
                System.out.println("Subtract : "+in3);
                break;

            case 3 :
                in3= in1 * in2;
                System.out.println("Multiplication : "+in3);
                break;
            case 4 :
                in3= in1/in2;
                System.out.println("Division : "+in3);
                break;
        }
        in.close();
    }

    public static class _2_pattern {
        public static void main(String[] args) {
            int it = 5;
            int n;
            for (int i = 0; i < it; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    public static class _6_insertElement {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter element :");
            int E = in.nextInt();
            System.out.println("Add element position at :");
            int po = in.nextInt();  //po= 2

            int[] arr= {12,23,34,45,56,67};
            int n = arr.length;
            System.out.println("Array : "+ Arrays.toString(arr));
            arr= ar(n,arr,po,E);
            System.out.println("Array now : "+ Arrays.toString(arr));

        }
        public static int[] ar(int n  , int[] arr, int po , int E){
            int[] new_array= new int[n+1];
            for (int i=0;i< n+1; i++){
                if (i < po-1){
                    new_array[i] = arr[i];
                }
                else if (i==po-1){
                    new_array[i]= E;
                }
                else {
                    new_array[i]= arr[i-1];
                }
            }
            return new_array;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
    }
}
