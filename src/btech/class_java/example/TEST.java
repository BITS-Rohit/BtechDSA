package Btech.class_java.example;

import java.util.Arrays;

public class TEST {
    static int fac(int n ){
        if (n==0) {
            return 1;
        }
//        System.out.println(n);
        return n *fac(n-1);
    }
    static void bubble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if ( arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
//        System.out.println(fac(40));
        int[] arr = {2,5,3,7,4};
        bubble(arr);
    }
}
