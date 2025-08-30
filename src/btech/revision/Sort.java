package JAVA.revision;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {2,3,8,9,0,1,10};
        System.out.println(Arrays.toString(mergesort(array)));
    }
    static int[] mergesort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left , right);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length+arr2.length];
        int i =0;
        int j =0;
        int k =0;
        while (i<arr1.length && j <arr2.length){
            if (arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
            }
            else {
                res[k]=arr2[j];
                j++;
            }
            k++;

        }
        while(i<arr1.length){
            res[k]=arr1[i];
            i++;
            k++;
        }
        while(j< arr2.length){
            res[k]=arr2[j];
            j++;
            k++;
        }
        return res;
    }
}
