package JAVA.exam;

import java.util.Arrays;

public class _7_ {
    public static void main(String[] args){
    int[] arr = {1,2,2,3,3,4,4,5,6};
    System.out.println("Array :" +Arrays.toString(arr));
    int n=arr.length;


        int j = 0;
        for (int i=0;i< n-1; i++){
            if (arr[i]!=arr[i+1]){
                arr[j++]=arr[i];
            }
        }
        arr[j++]=arr[n-1];
        for (int k=0;k<j; k++){
            System.out.println(arr[k]);
        }
    }
}
