package JAVA.MTE;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {

        int[] array = {4,13,0,5,8,9,1};
        System.out.println("\nInitial array is : "+Arrays.toString(array));
        System.out.println("\nSorted array is :"+Arrays.toString(sort(array)));

    }
    static int[] sort(int[] array ){
        if (array.length==1){
            return array;
        }
        int mid = array.length/2;

        int[] left =  sort(Arrays.copyOfRange(array,0,mid));
        int[] right = sort(Arrays.copyOfRange(array,mid,array.length));

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length+second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j <second.length){
            if (first[i]<second[j]){
                mix[k] = first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i< first.length){
            mix[k]= first[i];
            i++;
            k++;
        }
        while (j< second.length){
            mix[k]= second[j];
            j++;
            k++;
        }
        return mix;
    }
}
