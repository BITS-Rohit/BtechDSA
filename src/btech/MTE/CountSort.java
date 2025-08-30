package JAVA.MTE;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {2,3,4,1,5,6,2,7,8,2,8,3};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }
    static void countSort(int[] array){
        if (array==null || array.length<=1){
            return;
        }
        int max = array[0];
        for (int num : array){
            if ( num>max) max= num;
        }

        int[] CountedArray = new int[array.length+1];
        for (int num : array){
            CountedArray[num]++;
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (CountedArray[i]>0){
                array[index]=i;
                index++;
                CountedArray[i]--;
            }
        }
    }
}
