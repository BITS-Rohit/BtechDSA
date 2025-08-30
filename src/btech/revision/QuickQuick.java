package JAVA.revision;

import java.util.Arrays;

public class QuickQuick {
    public static void main(String[] args) {
        int[] arr  = {12,3,2,6,4,1,10};
        quicksort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quicksort(int[] arr,int low, int high){
        if (low>=high){
            return;
        }
        int start = 0;
        int end = arr.length-1;
        int pivot=arr[arr.length/2];
        while (start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while (arr[end]>pivot){
                end--;
            }
            if (start<=end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quicksort(arr,low,end);
        quicksort(arr,start,high);
    }
}
