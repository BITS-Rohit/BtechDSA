package JAVA.revision;

import java.util.Arrays;

public class SortQuick {
    public static void main(String[] args) {
        int[] arr = { 5,3,4,2,0,1,5};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quicksort(int[] arr , int low , int high){
        if (low >=high){
            return;
        }
        int s = low;
        int e = high;
        int mid  = (s+e)/2;
        int pivot = arr[mid];

        while (s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }
            if (s<=e){
                int temp = arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        quicksort(arr,low,e);
        quicksort(arr,s,high);
    }
}
