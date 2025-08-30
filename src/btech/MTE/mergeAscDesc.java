package JAVA.MTE;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class mergeAscDesc {
    public static void main(String[] args) {
        int[] array = {1,4,7,9,2,10,5};
        Scanner sc = new Scanner(in);
        System.out.print( "Enter choice (asc/desc): " ) ;
        String Choice = sc.next();
        System.out.println(Arrays.toString(merge(array,Choice)));
    }
    static int[] merge(int[] array, String Choice){
        if (array.length==1){
            return array;
        }
        int mid = array.length/2;
        int[] left = merge(Arrays.copyOfRange(array,0,mid),Choice);
        int[] right = merge(Arrays.copyOfRange(array,mid,array.length),Choice);

        return sort(left,right,Choice);
    }

    private static int[] sort(int[] first, int[] second, String choice) {
        int[] mix = new int[first.length+ second.length];
        if (choice.equals("Asc")|| choice.equals("asc")){
            int i = 0;
            int j = 0;
            int k = 0;
            while(i< first.length && j< second.length){
                if (first[i]<second[j]){
                    mix[k] = first[i];
                    i++;
                }
                else {
                    mix[k]=second[j];
                    j++;
                }
                k++;
            }
            while (i< first.length){
                mix[k]=first[i];
                i++;
                k++;
            }
            while (j<second.length){
                mix[k]=second[j];
                j++;
                k++;
            }
        }
        if (choice.equals("Desc") || choice.equals("desc")){
            int i = 0;
            int j = 0;
            int k = 0;
            while(i< first.length && j< second.length){
                if (first[i]>second[j]){
                    mix[k] = first[i];
                    i++;
                }
                else {
                    mix[k]=second[j];
                    j++;
                }
                k++;
            }
            while (i< first.length){
                mix[k]=first[i];
                i++;
                k++;
            }
            while (j<second.length){
                mix[k]=second[j];
                j++;
                k++;
            }
        }
        return mix;
    }

}
