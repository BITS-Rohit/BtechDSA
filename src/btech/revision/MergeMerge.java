package JAVA.revision;

import java.util.Arrays;

public class MergeMerge {
    public static void main(String[] args) {
        int[] arr = {2,36,5,4,1,0,3};
        System.out.println(Arrays.toString(merge(arr)));
    }
    static int[] merge(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = merge(Arrays.copyOfRange(arr,0,mid));
        int[] right =merge(Arrays.copyOfRange(arr,mid,arr.length));

        return sorting(left,right);
    }

    private static int[] sorting(int[] first, int[] second) {
        int[] mix = new int[first.length+second.length];
        int i =0;
        int j =0;
        int k =0;
        while(i<first.length && j< second.length){
            if (first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else {
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while(i < first.length){
            mix[k]=first[i];
            i++;
            k++;
        }

        while(j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
