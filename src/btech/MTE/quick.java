package JAVA.MTE;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
        int[] array = {2,3,5,6,1,10};
        Quick(array);
        System.out.println(Arrays.toString(array));
    }
    static void Quick(int[] array){
        int low =0;
        int high =array.length-1;
        sort(array, low , high);
    }

    private static void sort(int[] array, int low, int high) {
        if (low > high) return;
        int start = low ;
        int end = high;
        int pivot=(low+high)/2;

        while(start <= end ){
            while (array[start]<array[pivot]){
                start++;
            }
            while (array[end]>array[pivot]){
                end--;
            }
            if (start<=end){
                int temp = array[start];
                array[start]=array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        sort(array,low,end);
        sort(array,start,high);
    }
}
